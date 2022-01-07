package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
    @Size(max = 30, message = "Khong qua 30 ky tu")
    @NotNull
    @NotBlank
    private String username;
    @Size(max = 30, message = "Khong qua 30 ky tu")
    @NotNull
    @NotBlank
    private String password;
}
