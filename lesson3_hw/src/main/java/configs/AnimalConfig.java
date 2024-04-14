package configs;

import lesson4_hw.Eagle;
import lesson4_hw.Lion;
import lesson4_hw.Wolf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lesson4_hw")
public class AnimalConfig {

    @Bean
    public Lion lion() {
        Lion lion = new Lion();
        lion.setName("Simba");
        return lion;
    }

    @Bean
    public Wolf wolf() {
        Wolf wolf = new Wolf();
        wolf.setName("Jacob");
        return wolf;
    }

    @Bean
    public Eagle eagle() {
        Eagle eagle = new Eagle();
        eagle.setName("Falcon");
        return eagle;
    }
}
