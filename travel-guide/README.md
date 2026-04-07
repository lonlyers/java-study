# 🌍 Travel Guide - 旅游打卡攻略系统

A travel check-in guide system that allows you to create personalized travel itineraries and generate PDF guides.

## Features

1. **City Selection** - Browse and select from popular Chinese cities (Beijing, Shanghai, Chengdu, Xi'an, Hangzhou, Guilin)
2. **Attraction Management** - View all attractions for a city, select the ones you want to visit, and arrange them in your preferred order using drag-and-drop
3. **Photos & Notes** - Upload photos and write notes/comments for each attraction in your itinerary
4. **PDF Generation** - Generate a beautifully formatted PDF travel guide with your itinerary, photos, and notes

## Tech Stack

- **Backend**: Spring Boot 3.2 (Java 17)
- **Database**: H2 (embedded, file-based)
- **PDF Generation**: OpenPDF
- **Frontend**: Vanilla HTML/CSS/JavaScript

## Quick Start

### Prerequisites
- Java 17+
- Maven 3.6+

### Run the Application

```bash
cd travel-guide
mvn spring-boot:run
```

The application will start at **http://localhost:8080**

### Build

```bash
cd travel-guide
mvn clean package
java -jar target/travel-guide-1.0.0.jar
```

## Usage

1. Open http://localhost:8080 in your browser
2. **Create a Plan**: Select a city → pick attractions → set order → name your plan → create
3. **Edit Plan**: Click on a plan in "My Plans" to add comments and upload photos for each attraction
4. **Generate PDF**: Click "Generate PDF" to download a formatted travel guide

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/cities` | List all cities |
| GET | `/api/cities/{id}/attractions` | List attractions for a city |
| POST | `/api/plans` | Create a new travel plan |
| GET | `/api/plans` | List all travel plans |
| GET | `/api/plans/{id}` | Get plan details |
| GET | `/api/plans/{id}/attractions` | Get plan attractions |
| PUT | `/api/plans/attractions/{id}/comment` | Update attraction comment |
| POST | `/api/plans/attractions/{id}/photo` | Upload attraction photo |
| GET | `/api/plans/{id}/pdf` | Generate PDF guide |
| DELETE | `/api/plans/{id}` | Delete a plan |

## Project Structure

```
travel-guide/
├── pom.xml
├── src/main/java/com/zzw/travelguide/
│   ├── TravelGuideApplication.java
│   ├── model/          # Entity classes
│   ├── repository/     # JPA repositories
│   ├── service/        # Business logic
│   ├── controller/     # REST controllers
│   └── config/         # Configuration & data initializer
├── src/main/resources/
│   ├── application.yml
│   └── static/         # Frontend files (HTML/CSS/JS)
```
