package de.ait.repositories;

import de.ait.models.Course;
import de.ait.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LessonsRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByCourseId(Long courseId);
    Optional<Lesson> findByIdAndCourseId(Long lessonId, Long courseId);
    Optional<Lesson> findByCourseAndId(Course course, Long lessonId);
}
