package com.example.service;

import java.util.List;

import com.example.dto.UserRequestDTO;
import com.example.dto.UserResponseDTO;
import com.example.model.User;

public interface IUserService {
	List<UserResponseDTO> getAllUsers(String filter, String keyword);
	void createUser(UserRequestDTO userRequestDTO);
	UserResponseDTO getUser(Long id);
}
