package de.ait.services;

import de.ait.dto.NewUserDto;
import de.ait.dto.UserDto;

public interface UsersService {

    UserDto registerUser(NewUserDto newUser);
}