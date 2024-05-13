package de.ait.cars_driver;

import java.util.Set;

public class Car {
    private Long id;
    private String model;
    private String color;

    // many-to-one
    private Account owner;

    //many-to-many
    private Set<Account> drivers;
}
