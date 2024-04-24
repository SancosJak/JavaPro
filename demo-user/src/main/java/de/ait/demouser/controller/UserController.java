package de.ait.demouser.controller;


import de.ait.demouser.dto.NewUserDTO;
import de.ait.demouser.dto.UserDto;
import de.ait.demouser.models.User;
import de.ait.demouser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    public UserController(UserService userService){
//        this.userService = userService;
//    }


@GetMapping("/users")
@ResponseBody //означает что метод будет возвращать не название страницы а Json обьект
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }
@PostMapping("/users")
@ResponseBody
    public UserDto addUser(@RequestBody NewUserDTO newUserDTO){
        return userService.addUser(newUserDTO);

    }
}