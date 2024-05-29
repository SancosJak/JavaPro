package de.ait.dto;

import lombok.Data;

@Data
public class NewLessonDto {
    private Long existsLessonId;
    private String name;
    private String startTime;
    private String finishTime;
    private String dayOfWeek;
}
