package com.proyect1.prueba.apis;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.proyect1.prueba.domain.User;
import com.proyect1.prueba.repository.UserRepository;

@RestController
@RequestMapping("/apis")
public class UserController {
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	UserRepository repository;

	@GetMapping("/users")
	public List<User> findall() {
		return repository.findAll();
	}

	@PostMapping("/users")
	public User guardar(@RequestParam("usuario")String usuario,@RequestParam("nombres")String nombres,@RequestParam("apellidos")String apellidos,@RequestParam("dni")int dni,@RequestParam("correo")String correo,@RequestParam("contraseña")String contraseña)throws Exception {
		User user=new User();
		user.setUsuario(usuario);
		user.setNombres(nombres);
		user.setApellidos(apellidos);
		user.setDni(dni);
		user.setCorreo(correo);
		user.setContraseña(contraseña);
		return repository.save(user);
	}

	@GetMapping("/users/{id_usuario}")
	public Optional<User> buscarid(@PathVariable int id_usuario) {
		return repository.findById(id_usuario);
	}

	@PutMapping("/users/{id_usuario}")
	public User updateUser(@RequestBody User newUser, @PathVariable int id_usuario) {
		return repository.findById(id_usuario).map(user -> {
			user.setUsuario(newUser.getUsuario());
			user.setNombres(newUser.getNombres());
			user.setApellidos(newUser.getApellidos());
			user.setDni(newUser.getDni());
			user.setContraseña(newUser.getContraseña());
			return repository.save(user);
		}).orElseGet(() -> {
			newUser.setId_usuario(id_usuario);
			return repository.save(newUser);
		});
	}

	@DeleteMapping("/users/{id_usuario}")
	public void eliminar(@PathVariable int id_usuario) {
		repository.deleteById(id_usuario);
	}
}
