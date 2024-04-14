package lesson4_hw;

import configs.AnimalConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main_2_l5hw {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnimalConfig.class);

        AnimalService animalService = context.getBean(AnimalService.class);

        System.out.println("All animals:");
        for (Animal animal : animalService.getAnimals()) {
            System.out.println(animal.getClass().getSimpleName() + " makes sound: " + animal.makesSound());
        }

        System.out.println("\nLion:");
        System.out.println(animalService.getLion().getClass().getSimpleName() + " makes sound: " + animalService.getLion().makesSound());
    }
}
