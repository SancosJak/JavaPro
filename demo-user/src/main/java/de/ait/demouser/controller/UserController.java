package de.ait.demouser.controller;


import de.ait.demouser.dto.NewUserDTO;
import de.ait.demouser.dto.UserDto;
import de.ait.demouser.models.User;
import de.ait.demouser.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Tags(value = @Tag(name = "Users"))
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    public UserController(UserService userService){
//        this.userService = userService;
//    }

@Operation(summary = "Get all users", description = "available for administrator")
@GetMapping("/users")
@ResponseBody //означает что метод будет возвращать не название страницы а Json обьект
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @Operation(summary = "Add user", description = "available for administrator")
@PostMapping("/users")
@ResponseBody
    public UserDto addUser(@RequestBody NewUserDTO newUserDTO){
        return userService.addUser(newUserDTO);

    }
}