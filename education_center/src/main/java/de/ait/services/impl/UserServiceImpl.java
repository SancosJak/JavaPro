package de.ait.services.impl;

import de.ait.dto.NewUserDto;
import de.ait.models.User;
import de.ait.dto.UserDto;
import de.ait.exeptions.RestException;
import de.ait.repositories.UsersRepository;
import de.ait.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static de.ait.dto.UserDto.from;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UsersService {
    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDto registerUser(NewUserDto newUser) {
        if (userRepository.existsByEmail(newUser.getEmail())) {
            throw new RestException(HttpStatus.CONFLICT,
                    "User with email <" + newUser.getEmail() + "> already exists");
        }

        User user = User.builder()
                .email(newUser.getEmail())
                .password(passwordEncoder.encode(newUser.getPassword()))
                //.password(newUser.getPassword())
                .role(User.Role.USER)
                .build();
        userRepository.save(user);
        return  from(user);
    }
}
