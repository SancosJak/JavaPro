package de.ait.controllers;

import de.ait.dto.NewUserDto;
import de.ait.dto.UserDto;
import de.ait.services.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid NewUserDto newUser) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usersService.registerUser(newUser));
    }
}
