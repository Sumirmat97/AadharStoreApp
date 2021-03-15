package com.example.service;

import java.util.List;

import com.example.dto.UserRequestDTO;
import com.example.dto.UserResponseDTO;
import com.example.model.User;
import org.springframework.web.multipart.MultipartFile;

public interface IUserService {
	List<UserResponseDTO> getAllUsers(String filter, String keyword);
	void createUser(UserRequestDTO userRequestDTO, MultipartFile aadharFrontImg, MultipartFile aadharBackImg);
	UserResponseDTO getUser(Long id);
}
