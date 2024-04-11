package org.example;

public class Application {
    private int id;
    private String name;

    public Application() {
    }

    public Application(int id) {
        this.id = id;
    }

    public Application(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void init() {
        System.out.println("Bean initialization...");
    }
}
