package de.ait.services.impl;

import de.ait.dto.*;
import de.ait.exeptions.RestException;
import de.ait.models.Course;
import de.ait.models.Lesson;
import de.ait.models.User;
import de.ait.repositories.CoursesRepository;
import de.ait.repositories.LessonsRepository;
import de.ait.repositories.UsersRepository;
import de.ait.services.CoursesService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static de.ait.dto.CourseDto.from;
import static de.ait.dto.LessonDto.from;
import static de.ait.dto.UserDto.from;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CoursesServiceImpl implements CoursesService {
    private final CoursesRepository coursesRepository;
    private final LessonsRepository lessonsRepository;
    private Logger logger = LoggerFactory.getLogger(CoursesServiceImpl.class);
    private final UsersRepository studentRepository;

    @Override
    public CourseDto addCourse(NewCourseDto newCourse) {
        // здесь будет Join point,  т.е. место, куда мы хотим внедрить advice

        System.out.println("!!!!!!!!!!!!!!!!!ADD COURSE!!!!!!!!!!!!!!!!!!");

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

        String courseTitle = "Test course";

        logger.info("Database request: get all courses");
        logger.warn("Course with title {} not found",courseTitle);
        logger.error("SQL exception! Incorrect query");

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

        Lesson lesson;

        if (newLesson.getExistsLessonId() != null) {
           lesson = Lesson.builder()
                .name(newLesson.getName())
                .dayOfWeek(DayOfWeek.valueOf(newLesson.getDayOfWeek()))
                .startTime(LocalTime.parse(newLesson.getStartTime()))
                .finishTime(LocalTime.parse(newLesson.getFinishTime()))
                .course(course)//привязка курса к уроку
                .build();
        } else {
            lesson =lessonsRepository.findById(newLesson.getExistsLessonId())
                    .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                            "Lesson with id <" + newLesson.getExistsLessonId() + "> not found in course with id <" + courseId + ">"));
            lesson.setCourse(course);
        }
        lessonsRepository.save(lesson);
        return from(lesson);

    }
    //from lesson method
//    @Override
//    public List<LessonDto> getLessonsOfCourse(Long courseId) {
//        // найдем курс, у которого хотим получить уроки
//        Course course = getCourseOrThrow(courseId);
//
//        // получим уроки курса
//        Set<Lesson> lessons = course.getLessons();
//
//        // конвертируем в DTO
//        return from(lessons);
//    }



    @Override
    public List<LessonDto> getLessonsByCourseId(Long courseId) {
        getCourseOrThrow(courseId);
        List<Lesson> lessons = lessonsRepository.findByCourseId(courseId);

        return lessons.stream()
                .map(LessonDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public LessonDto getLessonByIdFromCourse(Long courseId, Long lessonId) {
        getCourseOrThrow(courseId);

        Lesson lesson = lessonsRepository.findByIdAndCourseId(lessonId, courseId)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                        "Lesson with id <" + lessonId + "> not found in course with id <" + courseId + ">"));

        return from(lesson);
    }

    @Override
    public LessonDto deleteLessonByIdFromCourse(Long courseId, Long lessonId) {
        getCourseOrThrow(courseId);
        Lesson lesson = lessonsRepository.findByIdAndCourseId(lessonId, courseId)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                        "Lesson with id <" + lessonId + "> not found in course with id <" + courseId + ">"));
        lessonsRepository.deleteById(lessonId);
        return from(lesson);
    }

    @Override
    public LessonDto updateLessonByIdFromCourse(Long courseId, Long lessonId, UpdateLessonDto updateLesson) {
        getCourseOrThrow(courseId);

        Lesson lesson = lessonsRepository.findByIdAndCourseId(lessonId, courseId)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                        "Lesson with id <" + lessonId + "> not found in course with id <" + courseId + ">"));
        lesson.setName(updateLesson.getName());
        lesson.setDayOfWeek(updateLesson.getDayOfWeek());
        lesson.setStartTime(updateLesson.getStartTime());
        lesson.setFinishTime(updateLesson.getFinishTime());
        lessonsRepository.save(lesson);

        return LessonDto.from(lesson);
    }

    @Override
    public LessonDto deleteLessonFromCourse(Long courseId, Long lessonId) {
        Course course = getCourseOrThrow(courseId);

        // вариант с циклом
//      Set<Lesson> lessons = course.getLessons();
//        for (Lesson lesson : lessonsOfCourse) {
//            if (lesson.getId().equals(lessonId)) {
//                lesson.setCourse(null);
//                lessonsRepository.save(lesson);
//                return from(lesson);
//            }
//         throw new RestException(HttpStatus.NOT_FOUND, "Lesson with id <" + lessonId + "> not found in course with id <" + courseId + ">");
//        }

        // вариант без цикла
        Lesson lesson = lessonsRepository.findByCourseAndId(course, lessonId)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                        "Lesson with id <" + lessonId + "> not found in course with id <" + courseId + ">"));
        lesson.setCourse(null);
        lessonsRepository.save(lesson);
        return from(lesson);
    }

    @Override
    public LessonDto updateLessonInCourse(Long courseId, Long lessonId, UpdateLessonDto updateLesson) {
        Course course = getCourseOrThrow(courseId);
        Lesson lesson = lessonsRepository.findByCourseAndId(course, lessonId)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                        "Lesson with id <" + lessonId + "> not found in course with id <" + courseId + ">"));
        lesson.setName(updateLesson.getName());
        lesson.setDayOfWeek(updateLesson.getDayOfWeek());
        lesson.setStartTime(updateLesson.getStartTime()); //LocalTime.parse
        lesson.setFinishTime(updateLesson.getFinishTime());
        lessonsRepository.save(lesson);
        return from(lesson);
    }

    @Override
    public List<UserDto> addStudentToCourse(Long courseId, StudentToCourseDto studentData) {
        Course course = getCourseOrThrow(courseId);
        User student = studentRepository.findById(studentData.getUserId())
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                        "Student with id <" + studentData.getUserId() + "> not found"));
// не рабочий вариант
//        course.getStudents().add(student);
//        coursesRepository.save(course);
        if (!student.getCourses().add(course)){
            throw new RestException(HttpStatus.BAD_REQUEST,
                    "Student with id <" + studentData.getUserId() + "> already added to course with id <" + courseId + ">");
        }
        studentRepository.save(student);
        Set<User> studentsOfCourse = studentRepository.findAllByCoursesContainsOrderById(course);
        return from(studentsOfCourse);
    }
}
