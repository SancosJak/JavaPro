package de.ait.demouser.dto;

import de.ait.demouser.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    @Schema(description = "user id", example = "1")
    private Long id;
    private String firstName;
    private String lastName;

    public static UserDto from (User user){
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName());

    }
//    public static List<UserDto> from (List<User> users){
//        List<UserDto> userDtos = new ArrayList<>();
//
//        for (User user : users) {
//            UserDto userDto = new UserDto(user.getFirstName(), user.getLastName());
//            userDtos.add(userDto);
//        }
//        return userDtos;
//    }
    public static List<UserDto> from (List<User> users){
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }


//    public UserDto(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public UserDto() {
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
}

