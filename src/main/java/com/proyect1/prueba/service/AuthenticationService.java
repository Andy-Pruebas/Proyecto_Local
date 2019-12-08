package com.proyect1.prueba.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.proyect1.prueba.domain.User;
import com.proyect1.prueba.repository.AuthenticationRepository;

@Service
public class AuthenticationService {
	private static final Logger logger=LoggerFactory.getLogger(AuthenticationService.class);
	@Autowired
	private AuthenticationRepository authenticationrepository;
	public User login(String usuario,String contraseña)throws BadCredentialsException{
		return authenticationrepository.login(usuario, contraseña);
	}
	public User findByusuario(String usuario)throws EmptyResultDataAccessException{
		return  authenticationrepository.findByusuario(usuario);
	}
	
}
