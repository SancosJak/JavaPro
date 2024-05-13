package de.ait.cars_driver;

import java.util.Set;

public class Account {
    private Long id;
    private String firstName;
    private String lastName;

    // one-to-many
    private Set<Car> ownedCars;

    //many-to-many
    private Set<Car> drivers;

}
