package com.example.util;

import com.example.dto.UserRequestDTO;
import com.example.dto.UserResponseDTO;
import com.example.model.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AdapterUtil {

    public static User adaptToUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setAddress(userRequestDTO.getAddress());
        user.setAadharNo(userRequestDTO.getAadharNo());
        user.setAadharFrontUrl(userRequestDTO.getAadharFrontUrl());
        user.setAadharBackUrl(userRequestDTO.getAadharBackUrl());
        user.setCreatedOn(new Date());
        return user;
    }

    public static UserResponseDTO adaptToUserResponseDTO(User user) {
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setAddress(user.getAddress());
        responseDTO.setName(user.getName());
        responseDTO.setAadharNo(user.getAadharNo());
        responseDTO.setAadharFrontUrl(user.getAadharFrontUrl());
        responseDTO.setAadharBackUrl(user.getAadharBackUrl());
        responseDTO.setCreatedOn(user.getCreatedOn());
        return responseDTO;
    }
}
