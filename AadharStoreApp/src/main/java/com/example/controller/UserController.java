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

import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService service;
	
	@GetMapping("")
	public ResponseEntity<List<UserResponseDTO>> getAllUsers(@RequestParam(required = false) String filter,
															 @RequestParam(required = false) String keyword)
	{
		return new ResponseEntity<>(service.getAllUsers(filter, keyword), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> getUser(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.getUser(id), HttpStatus.OK);
	}


	@PostMapping("")
	public ResponseEntity<String> createUser(@RequestParam("frontImg") MultipartFile aadharFrontImg,
											 @RequestParam("backImg") MultipartFile aadharBackImg,
											 @RequestBody UserRequestDTO userRequestDTO) {
		service.createUser(userRequestDTO, aadharFrontImg, aadharBackImg);
		return new ResponseEntity<>("User created successfully", HttpStatus.OK);
	}
	
}
