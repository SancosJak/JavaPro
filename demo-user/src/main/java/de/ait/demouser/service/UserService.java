package de.ait.demouser.service;


import de.ait.demouser.dto.NewUserDTO;
import de.ait.demouser.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();
    UserDto addUser(NewUserDTO newUserDTO);
}