package de.ait.services;

import de.ait.dto.CourseDto;
import de.ait.dto.NewCourseDto;
import de.ait.dto.UpdateCourseDto;

import java.util.List;

public interface CoursesService {
    CourseDto addCourse(NewCourseDto newCourse);

    List<CourseDto> getCourses();

    CourseDto getCourse(Long courseId);

    CourseDto deleteCourse(Long courseId);

    CourseDto updateCourse(Long courseId, UpdateCourseDto updateCourse);
}

