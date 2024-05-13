package de.ait.repositories;

import de.ait.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}