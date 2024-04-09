package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AppBeans.xml");

        Application application = (Application) context.getBean("application");

        application.setId(1);
        application.setName("HomeWork application");

        application.init();

        System.out.println("ID: " + application.getId());
        System.out.println("Name: " + application.getName());

        context.close();
    }
}