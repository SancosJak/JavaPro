package de.ait.demouser.controller;


import de.ait.demouser.dto.NewUserDTO;
import de.ait.demouser.dto.UserDto;
import de.ait.demouser.models.User;
import de.ait.demouser.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tags(value = @Tag(name = "Users"))
//@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

//    public UserController(UserService userService){
//        this.userService = userService;
//    }

@Operation(summary = "Get all users", description = "available for administrator")
//@GetMapping("/users")
@GetMapping()
//@ResponseBody //означает что метод будет возвращать не название страницы а Json обьект
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @Operation(summary = "Add user", description = "available for administrator")
//@PostMapping("/users")
@PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
//@ResponseBody
    public UserDto addUser(@RequestBody NewUserDTO newUserDTO){
        return userService.addUser(newUserDTO);
    }

    @Operation(summary = "Get user by id", description = "available for everyone")
    //@GetMapping("/users/{user-id}")
    @GetMapping("/{user-id}")
    public UserDto getUser(@PathVariable("user-id")Long id){
         return userService.getUser(id);

    }

    @Operation(summary = "update user", description = "available for admin")
    @PutMapping("/{user-id}")
    public UserDto updateUser(@PathVariable("user-id")Long id, @RequestBody UpdateUserDto updateUser){

    return userService.updateUser(id, updateUser);

    }
}