package de.ait.repositories;

import de.ait.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonsRepository extends JpaRepository<Lesson, Long> {
}
