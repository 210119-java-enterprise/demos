package com.revature.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data @NoArgsConstructor @AllArgsConstructor
public class Credentials {

    @NotNull @NotBlank
    private String username;

    @NotNull @NotBlank
    private String password;

}
