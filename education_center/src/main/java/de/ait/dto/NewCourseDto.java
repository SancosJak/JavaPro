package de.ait.dto;

import lombok.Data;

@Data
public class NewCourseDto {

    private String title;
    private String description;
    private String beginDate;
    private String endDate;
    private Double price;

}
