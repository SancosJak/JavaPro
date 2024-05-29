package de.ait.controllers;


import de.ait.dto.*;

import de.ait.services.CoursesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    private final CoursesService coursesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CourseDto> addCourse(@RequestBody @Valid NewCourseDto newCourse)
    {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(coursesService.addCourse(newCourse));
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getCourses()
    {
        return ResponseEntity
                .ok(coursesService.getCourses());
    }

    @GetMapping("/{course-id}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable("course-id") Long courseId){
        return ResponseEntity
                .ok(coursesService.getCourse(courseId));
    }
    @DeleteMapping("/{course-id}")
    public ResponseEntity<CourseDto> deleteCourse(@PathVariable("course-id") Long courseId){

        return ResponseEntity
                .ok(coursesService.deleteCourse(courseId));
    }

    @PutMapping("/{course-id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable("course-id") Long courseId, @RequestBody @Valid UpdateCourseDto updateCourse){
        return ResponseEntity
                .ok(coursesService.updateCourse(courseId, updateCourse));
    }

    //Endpoint для добавления урока в курс REST
    //POST/api/courses/{id-курса}/lessons
    @PostMapping("/{course_id}/lessons")
    public ResponseEntity<LessonDto> addLessonToCourse(@PathVariable("course_id") Long courseId, @RequestBody NewLessonDto newLesson){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(coursesService.addLessonToCourse(courseId,newLesson));
    }

    // end-point для получения всех уроков определленного курса REST
    // GET/api/courses/{id-курса}/lessons
    @GetMapping("/{course-id}/lessons")
    public ResponseEntity<List<LessonDto>> getLessonsByCourseId(@PathVariable("course-id") Long courseId) {
        return ResponseEntity
                .ok(coursesService.getLessonsByCourseId(courseId));
    }
    // end-point для получения конкретного урока по ID курса и урока
    @GetMapping("/{course-id}/lessons/{lesson-id}")
    public ResponseEntity<LessonDto> getLessonByIdFromCourse(
            @PathVariable("course-id") Long courseId,
            @PathVariable("lesson-id") Long lessonId) {
        return ResponseEntity
                .ok(coursesService.getLessonByIdFromCourse(courseId, lessonId));
    }
    // end-point для удаления конкретного урока по ID курса и урока
    @DeleteMapping("/{course-id}/lessons/{lesson-id}")
    public ResponseEntity<LessonDto> deleteLessonByIdFromCourse(
            @PathVariable("course-id") Long courseId,
            @PathVariable("lesson-id") Long lessonId) {
        return ResponseEntity
                .ok(coursesService.deleteLessonByIdFromCourse(courseId, lessonId));
    }
    // end-point для обновления конкретного урока по ID курса и урока
    @PutMapping("/{course-id}/lessons/{lesson-id}")
    public ResponseEntity<LessonDto> updateLessonByIdFromCourse(
            @PathVariable("course-id") Long courseId,
            @PathVariable("lesson-id") Long lessonId,
            @RequestBody @Valid UpdateLessonDto updateLesson) {
        return ResponseEntity
                .ok(coursesService.updateLessonByIdFromCourse(courseId, lessonId, updateLesson));
    }

    //class works methods
    @DeleteMapping("/{course-id}/lessons/{lesson-id}")
    public ResponseEntity<LessonDto> deleteLessonFromCourse(
            @PathVariable("course-id") Long courseId,
            @PathVariable("lesson-id") Long lessonId) {
        return ResponseEntity
                .ok(coursesService.deleteLessonFromCourse(courseId, lessonId));
    }

    @PutMapping("/{course-id}/lessons/{lesson-id}")
    public ResponseEntity<LessonDto> updateLessonInCourse(
            @PathVariable("course-id") Long courseId,
            @PathVariable("lesson-id") Long lessonId,
            @RequestBody @Valid UpdateLessonDto updateLesson) {
        return ResponseEntity
                .ok(coursesService.updateLessonInCourse(courseId, lessonId, updateLesson));
    }
    //добавления студентов курса

    @PostMapping("/{course-id}/students")
    public ResponseEntity<List<UserDto>> addStudentToCourse(
            @PathVariable("course-id") Long courseId,
            @RequestBody StudentToCourseDto studentData) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(coursesService.addStudentToCourse(courseId, studentData));
    }

}
