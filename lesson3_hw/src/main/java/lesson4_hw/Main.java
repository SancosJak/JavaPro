package lesson4_hw;

import configs.AnimalConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //Beans created by annotations
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext(AnimalConfig.class);

        Lion lion = annotationContext.getBean(Lion.class);
        Wolf wolf = annotationContext.getBean(Wolf.class);
        Eagle eagle = annotationContext.getBean(Eagle.class);

        System.out.println("\u001B[34mNames (annotations): \u001B[0m");
        System.out.println("Lion: " + lion.getName());
        System.out.println("Wolf: " + wolf.getName());
        System.out.println("Eagle: " + eagle.getName());

        //Beans created by XML
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("AnimalsBeans.xml");

        Lion lionXml = xmlContext.getBean(Lion.class);
        Wolf wolfXml = xmlContext.getBean(Wolf.class);
        Eagle eagleXml = xmlContext.getBean(Eagle.class);

        System.out.println("\u001B[35m \nNames (XML): \u001B[0m");
        System.out.println("Lion: " + lionXml.getName());
        System.out.println("Wolf: " + wolfXml.getName());
        System.out.println("Eagle: " + eagleXml.getName());
    }
}
