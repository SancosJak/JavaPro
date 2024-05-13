package de.ait.dto;

import de.ait.models.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonDto {
    private Long id;
    private String name;
    private String startTime;
    private String finishTime;
    private String dayOfWeek;
    private Long courseId;

    public static LessonDto from(Lesson lesson){

        return LessonDto.builder()
                .id(lesson.getId())
                .name(lesson.getName())
                .startTime(lesson.getStartTime().toString())
                .finishTime(lesson.getFinishTime().toString())
                .dayOfWeek(lesson.getDayOfWeek().toString())
                .courseId(lesson.getCourse().getId())
                .build();
    }
    
}
