package de.ait;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Builder
@Getter

public class Person {

    private String fName;
    private String lName;
    private int age;

}
