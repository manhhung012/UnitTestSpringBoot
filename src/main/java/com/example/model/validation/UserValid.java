package com.example.model.validation;

import com.example.entity.BaseEntity;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class UserValid extends BaseEntity {

    private Integer id;

    @NotBlank(message = "Username not is empty")
    private String userName;

    @NotBlank(message = "Password not is empty")
    private String password;

    @NotBlank(message = "Your name not is empty")
    private String fullName;

    private String phone;
}
