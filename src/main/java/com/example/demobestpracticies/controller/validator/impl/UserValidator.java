package com.example.demobestpracticies.controller.validator.impl;

import com.example.demobestpracticies.controller.validator.UserValidation;
import com.example.demobestpracticies.dto.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidator implements ConstraintValidator<UserValidation, UserDTO> {

    @Override
    public void initialize(UserValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserDTO user, ConstraintValidatorContext context) {
        return !user.getName().equalsIgnoreCase(user.getLastName());
    }
}