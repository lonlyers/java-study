package com.zzw.travelguide.config;

import com.zzw.travelguide.model.Attraction;
import com.zzw.travelguide.model.City;
import com.zzw.travelguide.repository.AttractionRepository;
import com.zzw.travelguide.repository.CityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CityRepository cityRepository;
    private final AttractionRepository attractionRepository;

    public DataInitializer(CityRepository cityRepository, AttractionRepository attractionRepository) {
        this.cityRepository = cityRepository;
        this.attractionRepository = attractionRepository;
    }

    @Override
    public void run(String... args) {
        if (cityRepository.count() > 0) {
            return;
        }

        // Beijing
        City beijing = cityRepository.save(new City("Beijing", "The capital of China, rich in history and culture."));
        attractionRepository.save(new Attraction("The Great Wall", "One of the Seven Wonders of the World, stretching over 13,000 miles.", "Badaling, Yanqing District", beijing));
        attractionRepository.save(new Attraction("Forbidden City", "The imperial palace from the Ming to Qing dynasties.", "4 Jingshan Front St, Dongcheng", beijing));
        attractionRepository.save(new Attraction("Temple of Heaven", "An imperial complex of religious buildings.", "1 Tiantan East Rd, Dongcheng", beijing));
        attractionRepository.save(new Attraction("Summer Palace", "A vast ensemble of lakes, gardens and palaces.", "19 Xinjiangongmen Rd, Haidian", beijing));
        attractionRepository.save(new Attraction("Tiananmen Square", "The largest city square in the world.", "Dongcheng District", beijing));
        attractionRepository.save(new Attraction("798 Art District", "A thriving artistic community with galleries and cafes.", "2 Jiuxianqiao Rd, Chaoyang", beijing));

        // Shanghai
        City shanghai = cityRepository.save(new City("Shanghai", "A global financial hub with a stunning skyline."));
        attractionRepository.save(new Attraction("The Bund", "A waterfront area with colonial-era buildings.", "Zhongshan East 1st Rd, Huangpu", shanghai));
        attractionRepository.save(new Attraction("Yu Garden", "A classical Chinese garden dating back to the Ming Dynasty.", "218 Anren St, Huangpu", shanghai));
        attractionRepository.save(new Attraction("Oriental Pearl Tower", "An iconic TV tower with observation decks.", "1 Century Ave, Pudong", shanghai));
        attractionRepository.save(new Attraction("Shanghai Museum", "One of China's first world-class modern museums.", "201 Renmin Ave, Huangpu", shanghai));
        attractionRepository.save(new Attraction("Nanjing Road", "One of the world's busiest shopping streets.", "Nanjing Rd, Huangpu", shanghai));
        attractionRepository.save(new Attraction("Zhujiajiao Water Town", "An ancient water town with bridges and canals.", "Zhujiajiao, Qingpu", shanghai));

        // Chengdu
        City chengdu = cityRepository.save(new City("Chengdu", "The land of abundance, famous for pandas and cuisine."));
        attractionRepository.save(new Attraction("Chengdu Research Base of Giant Panda Breeding", "Home to giant pandas and red pandas.", "1375 Xiongmao Ave, Chenghua", chengdu));
        attractionRepository.save(new Attraction("Jinli Ancient Street", "A traditional street with snacks and crafts.", "231 Wuhouci St, Wuhou", chengdu));
        attractionRepository.save(new Attraction("Wuhou Shrine", "A memorial shrine dedicated to Zhuge Liang.", "231 Wuhouci St, Wuhou", chengdu));
        attractionRepository.save(new Attraction("Kuanzhai Alley", "Three parallel alleys from the Qing Dynasty.", "Kuanzhai Xiangzi, Qingyang", chengdu));
        attractionRepository.save(new Attraction("Dujiangyan Irrigation System", "An ancient irrigation system still in use.", "Dujiangyan City", chengdu));

        // Xi'an
        City xian = cityRepository.save(new City("Xi'an", "The ancient capital with the Terracotta Army."));
        attractionRepository.save(new Attraction("Terracotta Army", "Thousands of life-size terracotta soldiers.", "Lintong District", xian));
        attractionRepository.save(new Attraction("City Wall of Xi'an", "One of the best-preserved ancient city walls.", "Huan Cheng Nan Lu, Beilin", xian));
        attractionRepository.save(new Attraction("Big Wild Goose Pagoda", "A well-preserved ancient Buddhist pagoda.", "Yanta South Rd, Yanta", xian));
        attractionRepository.save(new Attraction("Muslim Quarter", "A vibrant neighborhood with street food.", "Beiyuanmen, Lianhu", xian));
        attractionRepository.save(new Attraction("Huaqing Hot Springs", "Imperial hot springs with Tang Dynasty history.", "Lintong District", xian));

        // Hangzhou
        City hangzhou = cityRepository.save(new City("Hangzhou", "A city of natural beauty centered around West Lake."));
        attractionRepository.save(new Attraction("West Lake", "A UNESCO World Heritage Site surrounded by temples and pagodas.", "West Lake, Xihu", hangzhou));
        attractionRepository.save(new Attraction("Lingyin Temple", "One of China's largest and most famous Buddhist temples.", "1 Fayun Lane, Xihu", hangzhou));
        attractionRepository.save(new Attraction("Six Harmonies Pagoda", "A historic pagoda overlooking the Qiantang River.", "16 Zhijiang Rd, Xihu", hangzhou));
        attractionRepository.save(new Attraction("Longjing Tea Village", "Famous for Dragon Well Tea plantations.", "Longjing Rd, Xihu", hangzhou));
        attractionRepository.save(new Attraction("Hefang Street", "A historic pedestrian street with traditional shops.", "Hefang St, Shangcheng", hangzhou));

        // Guilin
        City guilin = cityRepository.save(new City("Guilin", "Known for its stunning karst landscape and rivers."));
        attractionRepository.save(new Attraction("Li River Cruise", "A scenic cruise through karst mountain landscapes.", "Li River, Guilin", guilin));
        attractionRepository.save(new Attraction("Reed Flute Cave", "A natural limestone cave with multicolored lighting.", "1 Ludi Rd, Xiufeng", guilin));
        attractionRepository.save(new Attraction("Elephant Trunk Hill", "A hill shaped like an elephant drinking water.", "1 Minzhu Rd, Xiangshan", guilin));
        attractionRepository.save(new Attraction("Yangshuo", "A county known for its dramatic karst scenery.", "Yangshuo County", guilin));
        attractionRepository.save(new Attraction("Longji Rice Terraces", "Stunning terraced rice paddies on mountain slopes.", "Longsheng County", guilin));
    }
}
