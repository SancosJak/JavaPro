package de.ait.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CoursesController {
    private final CoursesService coursesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto addCourse(@RequestBody NewCourseDto newCourse) {
        return coursesService.addCourse(newCourse);
    }
    @GetMapping
    public List<CourseDto> getCourses(){
        return coursesService.getCourses();
    }

}
