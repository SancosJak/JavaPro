package de.ait.mvcdemo.service;

import de.ait.mvcdemo.dto.RegisterDTO;
import de.ait.mvcdemo.models.User;

import java.util.List;

public interface UserService {

   // User addUser(String firstName, String lastName,String email, String password);
    User addUser(RegisterDTO registerDTO);

    List<User> getAllUsers();
}