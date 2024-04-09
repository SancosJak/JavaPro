import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
//AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//        HelloJava helloJava = (HelloJava) context.getBean("hello");
//        helloJava.getMessage();

//        context.registerShutdownHook(); // закрываем контекст

//        HelloJava helloJava1 = (HelloJava) context.getBean("hello");
//        helloJava1.setMessage("I am hello-1");
//        helloJava1.getMessage();
//
//        HelloJava helloJava2 = (HelloJava) context.getBean("hello");
//        helloJava2.getMessage();

        ApplicationContext context = new AnnotationConfigApplicationContext(HelloJavaConfig.class);
        HelloJava helloJava = context.getBean(HelloJava.class);
        helloJava.setMessage("Hello java Config");
        helloJava.getMessage();





    }
}
