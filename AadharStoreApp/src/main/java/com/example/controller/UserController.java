package com.example.controller;

import java.util.List;

import com.example.dto.UserRequestDTO;
import com.example.dto.UserResponseDTO;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	IUserService service;
	
	@GetMapping("getAll")
	public ResponseEntity<List<UserResponseDTO>> getAllUsers(@RequestParam("type") String filter,
															 @RequestParam("keyword") String keyword)
	{
		return new ResponseEntity<>(service.getAllUsers(filter, keyword), HttpStatus.OK);
	}

	@GetMapping("get/{id}")
	public ResponseEntity<UserResponseDTO> getUser(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.getUser(id), HttpStatus.OK);
	}


	@PostMapping("create")
	public ResponseEntity<String> createUser(@RequestParam("file") MultipartFile multipartFile,
											 @RequestBody UserRequestDTO userRequestDTO) {
		service.createUser(userRequestDTO, multipartFile);
		return new ResponseEntity<>("User created successfully", HttpStatus.OK);
	}
	
}
