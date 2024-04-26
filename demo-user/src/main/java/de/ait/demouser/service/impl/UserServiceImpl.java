package de.ait.demouser.service.impl;

import de.ait.demouser.dto.NewUserDTO;
import de.ait.demouser.dto.UserDto;
import de.ait.demouser.models.User;
import de.ait.demouser.repository.UserRepository;
import de.ait.demouser.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository; // зависимость от базы данных

//    public UserServiceImpl(@Qualifier("userRepositoryFileImpl") UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
public UserServiceImpl( UserRepository userRepository){
    this.userRepository = userRepository;
}

    @Override
    public List<UserDto> getAllUsers() {
//        List<User> users = userRepository.findAll();
//        List<UserDto> userDtos = new ArrayList<>();
//
//        for (User user : users) {
//            UserDto userDto = new UserDto(user.getFirstName(), user.getLastName());
//            userDtos.add(userDto);
//        }
//        return userDtos;
        return UserDto.from(userRepository.findAll());
    }

//    @Override
//    public UserDto addUser(NewUserDTO newUserDTO) {
//        User user = new User(newUserDTO.getFirstName(), newUserDTO.getLastName(), newUserDTO.getEmail(), newUserDTO.getPassword());
//        userRepository.save(user);
//       // return new UserDto(user.getFirstName(),user.getLastName());
//        return UserDto.from(user);
//    }
        @Override
    public UserDto addUser(NewUserDTO newUserDTO) {
    User user = User.builder()
            .firstName(newUserDTO.getFirstName())
            .lastName(newUserDTO.getLastName())
            .email(newUserDTO.getEmail())
            .password(newUserDTO.getPassword())
            .build();
            userRepository.save(user);
        return UserDto.from(user);
    }

    @Override
    public UserDto getUser(Long id) {
        return UserDto.from(userRepository.findById(id));
    }
}
