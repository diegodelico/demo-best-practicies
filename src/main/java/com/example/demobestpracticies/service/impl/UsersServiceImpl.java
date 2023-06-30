package com.example.demobestpracticies.service.impl;

import com.example.demobestpracticies.dto.UserDTO;
import com.example.demobestpracticies.mapper.UserMapper;
import com.example.demobestpracticies.model.UserModel;
import com.example.demobestpracticies.repository.UserRepository;
import com.example.demobestpracticies.service.UsersService;
import feign.FeignException;
import feign.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService {

    @Override public UserDTO getUser(Long id) {
        throw new FeignException.FeignClientException(407, "Error comunicacion API",
                Request.create(Request.HttpMethod.GET, "http://url-api", new HashMap<>(), null, null, null), null, null);
    }

    @Override public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override public void addUser(UserDTO user) {
        log.info(user.getRut());
    }

    @Override public void updateUser(Long id, UserDTO user) {

    }

}
