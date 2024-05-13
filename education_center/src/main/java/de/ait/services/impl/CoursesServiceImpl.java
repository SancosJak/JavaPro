package de.ait.services.impl;

import de.ait.dto.*;
import de.ait.exeptions.RestException;
import de.ait.models.Course;
import de.ait.models.Lesson;
import de.ait.repositories.CoursesRepository;
import de.ait.repositories.LessonsRepository;
import de.ait.services.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static de.ait.dto.CourseDto.from;
import static de.ait.dto.LessonDto.from;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CoursesServiceImpl implements CoursesService {
    private final CoursesRepository coursesRepository;
    private final LessonsRepository lessonsRepository;

    @Override
    public CourseDto addCourse(NewCourseDto newCourse) {
        Course course = Course.builder()
                .title(newCourse.getTitle())
                .description(newCourse.getDescription())
                .beginDate(LocalDate.parse(newCourse.getBeginDate()))
                .endDate(LocalDate.parse(newCourse.getEndDate()))
                .price(newCourse.getPrice())
                .state(Course.State.DRAFT)
                .build();
        coursesRepository.save(course);
        return from(course);
    }

    @Override
    public List<CourseDto> getCourses() {
         List<Course> courses = coursesRepository.findAll();
         return from(courses);
    }

    @Override
    public CourseDto getCourse(Long courseId) {
        Course course = getCourseOrThrow(courseId);
        return from(course);
    }

    private Course getCourseOrThrow(Long courseId) {
        return coursesRepository.findById(courseId)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Course with id <" + courseId + "> not found"));
    }

    @Override
    public CourseDto deleteCourse(Long courseId) {
        Course course = getCourseOrThrow(courseId);
        coursesRepository.deleteById(courseId);

        return from(course);
    }

    @Override
    public CourseDto updateCourse(Long courseId, UpdateCourseDto updateCourseDto) {
        Course course = getCourseOrThrow(courseId);

        course.setTitle(updateCourseDto.getTitle());
        course.setDescription(updateCourseDto.getDescription());
        course.setBeginDate(LocalDate.parse(updateCourseDto.getBeginDate()));
        course.setEndDate(LocalDate.parse(updateCourseDto.getEndDate()));
        course.setPrice(updateCourseDto.getPrice());

        coursesRepository.save(course);
        return from(course);
    }

    @Override
    public LessonDto addLessonToCourse(Long courseId, NewLessonDto newLesson) {
        Course course = getCourseOrThrow(courseId);

        Lesson lesson = Lesson.builder()
                .name(newLesson.getName())
                .dayOfWeek(DayOfWeek.valueOf(newLesson.getDayOfWeek()))
                .startTime(LocalTime.parse(newLesson.getStartTime()))
                .finishTime(LocalTime.parse(newLesson.getFinishTime()))
                .course(course)//привязка курса к уроку
                .build();
        lessonsRepository.save(lesson);
        return from(lesson);

    }
}
