package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.dto.UserRequestDTO;
import com.example.dto.UserResponseDTO;
import com.example.util.AdapterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository repository;

	@Autowired
	IFileUpload fileUploadService;
	
	@Override
	public List<UserResponseDTO> getAllUsers(String filter, String keyword) {
		if(filter != null && keyword != null) {
			switch(filter)
			{
				case "name": return repository.searchByName(keyword).stream().map(AdapterUtil::adaptToUserResponseDTO).collect(Collectors.toList());
				case "address": return repository.searchByAddress(keyword).stream().map(AdapterUtil::adaptToUserResponseDTO).collect(Collectors.toList());
				case "aadhar": return repository.searchByAadhar(keyword).stream().map(AdapterUtil::adaptToUserResponseDTO).collect(Collectors.toList());
			}
		}
		return (List<UserResponseDTO>) repository.findAll().stream().map(AdapterUtil::adaptToUserResponseDTO).collect(Collectors.toList());
	}

	@Override
	public UserResponseDTO getUser(Long id) {
		Optional<User> user = repository.findById(id);
		
		if(user.isPresent())
		{
			System.out.println(user.get());
			return AdapterUtil.adaptToUserResponseDTO(user.get());
		}
		return null;
	}

	@Override
	public void createUser(UserRequestDTO userRequestDTO, MultipartFile aadharFrontImg, MultipartFile aadharBackImg){
		userRequestDTO.setAadharFrontUrl(fileUploadService.storeFile(aadharFrontImg));
		userRequestDTO.setAadharBackUrl(fileUploadService.storeFile(aadharBackImg));
		
		User user = AdapterUtil.adaptToUser(userRequestDTO);
		repository.save(user);
	}



}
