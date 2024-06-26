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

    List<LessonDto> getLessonsByCourseId(Long courseId);

    LessonDto getLessonByIdFromCourse(Long courseId, Long lessonId);

    LessonDto deleteLessonByIdFromCourse(Long courseId, Long lessonId);

    LessonDto updateLessonByIdFromCourse(Long courseId, Long lessonId, UpdateLessonDto updateLesson);

    LessonDto deleteLessonFromCourse(Long courseId, Long lessonId);

    LessonDto updateLessonInCourse(Long courseId, Long lessonId, UpdateLessonDto updateLesson);


    List<UserDto> addStudentToCourse(Long courseId, StudentToCourseDto studentData);

    List<UserDto> getStudentsByCourseId(Long courseId);
}

