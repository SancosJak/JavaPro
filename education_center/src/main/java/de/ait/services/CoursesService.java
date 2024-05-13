package de.ait.services;

import de.ait.dto.*;

import java.util.List;

public interface CoursesService {
    CourseDto addCourse(NewCourseDto newCourse);

    List<CourseDto> getCourses();

    CourseDto getCourse(Long courseId);

    CourseDto deleteCourse(Long courseId);

    CourseDto updateCourse(Long courseId, UpdateCourseDto updateCourse);

    LessonDto addLessonToCourse(Long courseId, NewLessonDto newLesson);
}

