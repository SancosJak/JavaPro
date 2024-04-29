package de.ait.demouser.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Update user", description = "Info fro updating user`s name and surname")

public class UpdateUserDto {
    @Schema(description = "User`s first name", example = "John")
    private String firstName;

    @Schema(description = "User`s surname")
    private String lastName;
}