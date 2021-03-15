package com.example.service;

import java.util.List;

import com.example.model.User;

public interface IUserService {
	List<User> getAllUsers(String filter, String keyword);
	void createUser();
	User getUser(Long id);
}
