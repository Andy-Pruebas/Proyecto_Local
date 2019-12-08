package com.proyect1.prueba.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyect1.prueba.domain.User;
import com.proyect1.prueba.service.AuthenticationService;

@RestController
@RequestMapping("/sistema")
public class AuthenticationController {
	@Autowired
	private AuthenticationService authenticationservice;
	
	@PostMapping("Login")
	public User login(@RequestParam(required=false,name="usuario") String usuario, @RequestParam(required=false,name="contraseña") String contraseña){
		User user= authenticationservice.login(usuario, contraseña);
		return user;
	}
}
