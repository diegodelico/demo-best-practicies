package com.example.demobestpracticies.mapper;

import com.example.demobestpracticies.dto.UserDTO;
import com.example.demobestpracticies.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    @Mapping(source = "", target = "")
    UserDTO userToDto(UserModel user);
}
