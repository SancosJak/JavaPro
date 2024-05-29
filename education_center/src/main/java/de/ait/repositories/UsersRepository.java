package de.ait.repositories;

import de.ait.models.Course;
import de.ait.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface UsersRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
    Set<User> findAllByCoursesContainsOrderById(Course course);
}