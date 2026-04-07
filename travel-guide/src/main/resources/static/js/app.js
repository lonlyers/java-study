// ===== State Management =====
const state = {
    cities: [],
    selectedCityId: null,
    attractions: [],
    selectedAttractionIds: [],
    plans: [],
    currentPlanId: null,
};

// ===== API Helper =====
async function api(url, options = {}) {
    const response = await fetch(url, options);
    if (!response.ok) {
        const errorData = await response.json().catch(() => ({}));
        throw new Error(errorData.error || 'Request failed');
    }
    return response;
}

async function apiJson(url, options = {}) {
    const response = await api(url, options);
    return response.json();
}

// ===== Toast Notification =====
function showToast(message, type = '') {
    const toast = document.getElementById('toast');
    toast.textContent = message;
    toast.className = 'toast ' + type;
    toast.style.display = 'block';
    setTimeout(() => { toast.style.display = 'none'; }, 3000);
}

// ===== Loading Overlay =====
function showLoading() {
    document.getElementById('loading-overlay').style.display = 'flex';
}

function hideLoading() {
    document.getElementById('loading-overlay').style.display = 'none';
}

// ===== Tab Navigation =====
document.querySelectorAll('.tab-btn').forEach(btn => {
    btn.addEventListener('click', () => {
        document.querySelectorAll('.tab-btn').forEach(b => b.classList.remove('active'));
        document.querySelectorAll('.tab-content').forEach(c => c.classList.remove('active'));
        btn.classList.add('active');
        const tabId = btn.dataset.tab + '-tab';
        document.getElementById(tabId).classList.add('active');

        if (btn.dataset.tab === 'plans') {
            loadPlans();
        }
    });
});

// ===== Load Cities =====
async function loadCities() {
    try {
        state.cities = await apiJson('/api/cities');
        renderCities();
    } catch (e) {
        showToast('Failed to load cities: ' + e.message, 'error');
    }
}

function renderCities() {
    const container = document.getElementById('city-list');
    container.innerHTML = state.cities.map(city => `
        <div class="city-card ${state.selectedCityId === city.id ? 'selected' : ''}"
             data-city-id="${city.id}" onclick="selectCity(${city.id})">
            <h4>${escapeHtml(city.name)}</h4>
            <p>${escapeHtml(city.description || '')}</p>
        </div>
    `).join('');
}

// ===== Select City =====
async function selectCity(cityId) {
    state.selectedCityId = cityId;
    state.selectedAttractionIds = [];
    renderCities();

    try {
        state.attractions = await apiJson(`/api/cities/${cityId}/attractions`);
        renderAvailableAttractions();
        renderSelectedAttractions();
        document.getElementById('attractions-section').style.display = 'block';
        document.getElementById('create-section').style.display = 'block';

        // Set default plan title
        const city = state.cities.find(c => c.id === cityId);
        if (city) {
            document.getElementById('plan-title').value = city.name + ' Travel Guide';
        }
    } catch (e) {
        showToast('Failed to load attractions: ' + e.message, 'error');
    }
}

// ===== Render Available Attractions =====
function renderAvailableAttractions() {
    const container = document.getElementById('available-attractions');
    const available = state.attractions.filter(a => !state.selectedAttractionIds.includes(a.id));

    if (available.length === 0) {
        container.innerHTML = '<p class="empty-state" style="padding: 20px;">All attractions selected!</p>';
        return;
    }

    container.innerHTML = available.map(a => `
        <div class="attraction-item" onclick="addAttraction(${a.id})">
            <div>
                <div class="attraction-name">${escapeHtml(a.name)}</div>
                <div class="attraction-addr">${escapeHtml(a.address || '')}</div>
            </div>
            <span style="color: #27ae60; font-size: 1.2rem;">+</span>
        </div>
    `).join('');
}

// ===== Render Selected Attractions =====
function renderSelectedAttractions() {
    const container = document.getElementById('selected-attractions');

    if (state.selectedAttractionIds.length === 0) {
        container.innerHTML = '<p class="empty-state" style="padding: 20px;">Drag attractions here or click + to add</p>';
        return;
    }

    container.innerHTML = state.selectedAttractionIds.map((id, index) => {
        const a = state.attractions.find(attr => attr.id === id);
        if (!a) return '';
        return `
            <div class="attraction-item selected" draggable="true"
                 data-attraction-id="${a.id}" data-index="${index}">
                <div style="display: flex; align-items: center; gap: 10px; flex: 1;">
                    <span class="order-badge">${index + 1}</span>
                    <div>
                        <div class="attraction-name">${escapeHtml(a.name)}</div>
                        <div class="attraction-addr">${escapeHtml(a.address || '')}</div>
                    </div>
                </div>
                <button class="remove-btn" onclick="removeAttraction(${a.id}); event.stopPropagation();">&times;</button>
            </div>
        `;
    }).join('');

    // Setup drag and drop
    setupDragAndDrop();
}

// ===== Add/Remove Attractions =====
function addAttraction(id) {
    if (!state.selectedAttractionIds.includes(id)) {
        state.selectedAttractionIds.push(id);
        renderAvailableAttractions();
        renderSelectedAttractions();
    }
}

function removeAttraction(id) {
    state.selectedAttractionIds = state.selectedAttractionIds.filter(aid => aid !== id);
    renderAvailableAttractions();
    renderSelectedAttractions();
}

// ===== Drag and Drop for Reordering =====
function setupDragAndDrop() {
    const container = document.getElementById('selected-attractions');
    const items = container.querySelectorAll('.attraction-item');

    items.forEach(item => {
        item.addEventListener('dragstart', (e) => {
            item.classList.add('dragging');
            e.dataTransfer.effectAllowed = 'move';
            e.dataTransfer.setData('text/plain', item.dataset.index);
        });

        item.addEventListener('dragend', () => {
            item.classList.remove('dragging');
        });

        item.addEventListener('dragover', (e) => {
            e.preventDefault();
            e.dataTransfer.dropEffect = 'move';
        });

        item.addEventListener('drop', (e) => {
            e.preventDefault();
            const fromIndex = parseInt(e.dataTransfer.getData('text/plain'));
            const toIndex = parseInt(item.dataset.index);

            if (fromIndex !== toIndex) {
                const movedId = state.selectedAttractionIds.splice(fromIndex, 1)[0];
                state.selectedAttractionIds.splice(toIndex, 0, movedId);
                renderSelectedAttractions();
            }
        });
    });
}

// ===== Create Plan =====
document.getElementById('create-plan-btn').addEventListener('click', async () => {
    const title = document.getElementById('plan-title').value.trim();
    if (!title) {
        showToast('Please enter a plan title', 'error');
        return;
    }
    if (state.selectedAttractionIds.length === 0) {
        showToast('Please select at least one attraction', 'error');
        return;
    }

    showLoading();
    try {
        const plan = await apiJson('/api/plans', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                title: title,
                cityId: state.selectedCityId,
                attractionIds: state.selectedAttractionIds,
            }),
        });

        showToast('Plan created successfully!', 'success');

        // Reset form
        state.selectedAttractionIds = [];
        state.selectedCityId = null;
        document.getElementById('plan-title').value = '';
        document.getElementById('attractions-section').style.display = 'none';
        document.getElementById('create-section').style.display = 'none';
        renderCities();

        // Switch to plans tab and show detail
        document.querySelector('[data-tab="plans"]').click();
        openPlanDetail(plan.id);
    } catch (e) {
        showToast('Failed to create plan: ' + e.message, 'error');
    } finally {
        hideLoading();
    }
});

// ===== Load Plans =====
async function loadPlans() {
    try {
        state.plans = await apiJson('/api/plans');
        renderPlans();
    } catch (e) {
        showToast('Failed to load plans: ' + e.message, 'error');
    }
}

function renderPlans() {
    const container = document.getElementById('plans-list');

    if (state.plans.length === 0) {
        container.innerHTML = `
            <div class="empty-state">
                <p>📭 No travel plans yet</p>
                <p>Create your first travel plan!</p>
            </div>
        `;
        return;
    }

    container.innerHTML = state.plans.map(plan => {
        const date = plan.createdAt
            ? new Date(plan.createdAt).toLocaleDateString('zh-CN')
            : '';
        return `
            <div class="plan-card" onclick="openPlanDetail(${plan.id})">
                <div class="plan-info">
                    <h4>${escapeHtml(plan.title)}</h4>
                    <p>${escapeHtml(plan.city ? plan.city.name : '')}</p>
                </div>
                <div class="plan-meta">
                    <div>${date}</div>
                    <div>${plan.planAttractions ? plan.planAttractions.length : 0} attractions</div>
                </div>
            </div>
        `;
    }).join('');
}

// ===== Open Plan Detail Modal =====
async function openPlanDetail(planId) {
    state.currentPlanId = planId;
    showLoading();

    try {
        const plan = await apiJson(`/api/plans/${planId}`);
        const attractions = await apiJson(`/api/plans/${planId}/attractions`);

        document.getElementById('detail-plan-title').textContent = plan.title;
        document.getElementById('detail-plan-city').textContent =
            '📍 ' + (plan.city ? plan.city.name : '') +
            ' | Created: ' + (plan.createdAt ? new Date(plan.createdAt).toLocaleDateString('zh-CN') : '');

        renderDetailAttractions(attractions);
        document.getElementById('plan-detail-modal').style.display = 'flex';
    } catch (e) {
        showToast('Failed to load plan details: ' + e.message, 'error');
    } finally {
        hideLoading();
    }
}

function renderDetailAttractions(attractions) {
    const container = document.getElementById('detail-attractions');

    container.innerHTML = attractions.map(pa => `
        <div class="detail-attraction-card" data-pa-id="${pa.id}">
            <div class="detail-attraction-header">
                <span class="detail-order-badge">${pa.sortOrder}</span>
                <h4>${escapeHtml(pa.attraction.name)}</h4>
            </div>
            ${pa.attraction.address ? `<div class="detail-attraction-addr">📍 ${escapeHtml(pa.attraction.address)}</div>` : ''}
            ${pa.attraction.description ? `<div class="detail-attraction-desc">${escapeHtml(pa.attraction.description)}</div>` : ''}

            <div class="comment-section">
                <label>📝 Notes / Comments:</label>
                <textarea class="comment-textarea" id="comment-${pa.id}"
                          placeholder="Write your notes about this attraction...">${escapeHtml(pa.comment || '')}</textarea>
                <button class="save-comment-btn" onclick="saveComment(${pa.id})">Save Comment</button>
            </div>

            <div class="photo-section">
                <label>📷 Photo:</label>
                <div class="photo-upload-area">
                    ${pa.photoPath
                        ? `<img src="/uploads/${encodeURIComponent(pa.photoPath)}" class="photo-preview" alt="Photo">`
                        : '<span style="color: #bdc3c7;">No photo uploaded</span>'}
                    <label class="upload-btn">
                        📤 Upload Photo
                        <input type="file" accept="image/*" style="display: none;"
                               onchange="uploadPhoto(${pa.id}, this)">
                    </label>
                </div>
            </div>
        </div>
    `).join('');
}

// ===== Save Comment =====
async function saveComment(planAttractionId) {
    const comment = document.getElementById('comment-' + planAttractionId).value;

    try {
        await apiJson(`/api/plans/attractions/${planAttractionId}/comment`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ comment: comment }),
        });
        showToast('Comment saved!', 'success');
    } catch (e) {
        showToast('Failed to save comment: ' + e.message, 'error');
    }
}

// ===== Upload Photo =====
async function uploadPhoto(planAttractionId, input) {
    const file = input.files[0];
    if (!file) return;

    // Validate file size (max 10MB)
    if (file.size > 10 * 1024 * 1024) {
        showToast('File size must be less than 10MB', 'error');
        return;
    }

    const formData = new FormData();
    formData.append('file', file);

    showLoading();
    try {
        await api(`/api/plans/attractions/${planAttractionId}/photo`, {
            method: 'POST',
            body: formData,
        });
        showToast('Photo uploaded!', 'success');
        // Refresh the detail view
        openPlanDetail(state.currentPlanId);
    } catch (e) {
        showToast('Failed to upload photo: ' + e.message, 'error');
    } finally {
        hideLoading();
    }
}

// ===== Generate PDF =====
document.getElementById('generate-pdf-btn').addEventListener('click', async () => {
    showLoading();
    try {
        const response = await api(`/api/plans/${state.currentPlanId}/pdf`);
        const blob = await response.blob();
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = 'travel-guide.pdf';
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
        window.URL.revokeObjectURL(url);
        showToast('PDF generated successfully!', 'success');
    } catch (e) {
        showToast('Failed to generate PDF: ' + e.message, 'error');
    } finally {
        hideLoading();
    }
});

// ===== Delete Plan =====
document.getElementById('delete-plan-btn').addEventListener('click', async () => {
    if (!confirm('Are you sure you want to delete this plan?')) return;

    showLoading();
    try {
        await api(`/api/plans/${state.currentPlanId}`, { method: 'DELETE' });
        showToast('Plan deleted!', 'success');
        document.getElementById('plan-detail-modal').style.display = 'none';
        loadPlans();
    } catch (e) {
        showToast('Failed to delete plan: ' + e.message, 'error');
    } finally {
        hideLoading();
    }
});

// ===== Close Modal =====
document.getElementById('close-modal').addEventListener('click', () => {
    document.getElementById('plan-detail-modal').style.display = 'none';
});

document.getElementById('plan-detail-modal').addEventListener('click', (e) => {
    if (e.target === e.currentTarget) {
        document.getElementById('plan-detail-modal').style.display = 'none';
    }
});

// ===== Utility: Escape HTML =====
function escapeHtml(text) {
    if (!text) return '';
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
}

// ===== Initialize =====
loadCities();
