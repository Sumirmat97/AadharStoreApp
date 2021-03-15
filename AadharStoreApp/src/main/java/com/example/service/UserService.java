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

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository repository;
	
	@Override
	public List<UserResponseDTO> getAllUsers(String filter, String keyword) {
		if(filter != null && keyword != null) {
			return repository.search(filter, keyword).stream().map(AdapterUtil::adaptToUserResponseDTO).collect(Collectors.toList());
		}
		return (List<UserResponseDTO>) repository.findAll().stream().map(AdapterUtil::adaptToUserResponseDTO).collect(Collectors.toList());
	}

	@Override
	public void createUser(UserRequestDTO userRequestDTO){
		User user = AdapterUtil.adaptToUser(userRequestDTO);
		repository.save(user);
	}

	@Override
	public UserResponseDTO getUser(Long id) {
		Optional<User> user = repository.findById(id);
		if(user.isPresent())
			return AdapterUtil.adaptToUserResponseDTO(user.get());
		return null;
	}

}
