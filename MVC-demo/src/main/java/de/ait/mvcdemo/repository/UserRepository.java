package de.ait.mvcdemo.repository;

import de.ait.mvcdemo.models.User;

public interface UserRepository extends CrudRepository<User> {

    // User findByEmail(String email);
}