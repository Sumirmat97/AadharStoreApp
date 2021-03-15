package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository repository;
	
	@Override
	public List<User> getAllUsers(String filter, String keyword) {
		if(filter != null && keyword != null)
			return repository.search(filter, keyword);
		return (List<User>) repository.findAll();
	}

	@Override
	public void createUser() {
		// TODO Auto-generated method stub
	}

	@Override
	public User getUser(Long id) {
		Optional<User> user = repository.findById(id);
		if(user.isPresent())
			return user.get();
		return null;
	}

}
