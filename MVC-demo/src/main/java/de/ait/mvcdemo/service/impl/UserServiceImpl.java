package de.ait.mvcdemo.service.impl;

import de.ait.mvcdemo.dto.RegisterDTO;
import de.ait.mvcdemo.models.User;
import de.ait.mvcdemo.repository.UserRepository;
import de.ait.mvcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository; // зависимость от базы данных

    public UserServiceImpl(@Qualifier("userRepositoryFileImpl") UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //метод добавления пользователя
//    @Override
//    public User addUser(String firstName, String lastName, String email, String password) {
//
//        User user = new User(firstName,lastName,email,password);//создаем юзера
//        userRepository.save(user); // сохраняем юзера в бд
//
//        return user;
//    }
    @Override
    public User addUser(RegisterDTO registerDTO) {

        User user = new User(registerDTO.getInputFirstName(), registerDTO.getInputLastName(), registerDTO.getInputEmail(), registerDTO.getInputPassword());
        userRepository.save(user); // сохраняем юзера в бд

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(); // просто запрашиваем у репозитория
    }
}
