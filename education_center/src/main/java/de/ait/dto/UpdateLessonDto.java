package de.ait.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
public class UpdateLessonDto {
    @NotBlank(message = "Lesson name is required")
    private String name;

    @NotNull(message = "Day of week is required")
    private DayOfWeek dayOfWeek;

    @NotNull(message = "Start time is required")
    private LocalTime startTime;

    @NotNull(message = "Finish time is required")
    private LocalTime finishTime;
}
