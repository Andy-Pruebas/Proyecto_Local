package com.proyect1.prueba.service;

import java.util.List;

import com.proyect1.prueba.domain.User;

public interface UserService {
	public void saveUser(User user);
	
	public boolean isUserAlreadyPresent(User user);

	public List<User> findAll();
	public User findById(int id);
}
