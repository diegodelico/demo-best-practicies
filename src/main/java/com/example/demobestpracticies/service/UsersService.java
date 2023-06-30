package com.example.demobestpracticies.service;

import com.example.demobestpracticies.dto.UserDTO;

import java.util.List;

public interface UsersService {

    UserDTO getUser(Long id);

    List<UserDTO> getAllUsers();

    void addUser(UserDTO user);

    void updateUser(Long id, UserDTO user);

}
