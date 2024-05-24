package de.ait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Locale;

@SpringBootApplication
public class EducationCenterApplication {
    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();

    }

    public static void main(String[] args) {
       // Locale.setDefault(Locale.ENGLISH);
        SpringApplication.run(EducationCenterApplication.class, args);
    }

}
