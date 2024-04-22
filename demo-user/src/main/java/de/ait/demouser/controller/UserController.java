package de.ait.demouser.controller;


import de.ait.demouser.models.User;
import de.ait.demouser.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


@GetMapping("/users")
@ResponseBody //означает что метод будет возвращать не название страницы а Json обьект
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}