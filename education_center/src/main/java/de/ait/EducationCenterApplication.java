package de.ait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class EducationCenterApplication {

    public static void main(String[] args) {
       // Locale.setDefault(Locale.ENGLISH);
        SpringApplication.run(EducationCenterApplication.class, args);
    }

}
