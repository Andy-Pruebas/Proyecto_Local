package com.proyect1.prueba.apis;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyect1.prueba.domain.Lengua;
import com.proyect1.prueba.repository.LenguaRepository;

@RestController
@RequestMapping("/apis")
public class LenguaController {

	@Autowired
	LenguaRepository lenguar;

	@GetMapping("/lenguas")
	public List<Lengua> findAll() {
		return lenguar.findAll();
	}
	@PostMapping("/lenguas")
	public Lengua almacen(@RequestBody Lengua lengua){
		return lenguar.save(lengua);
	}
	@GetMapping("/lenguas/{id_leng}")
	public Optional<Lengua> findid(@PathVariable int id_leng) {
		return lenguar.findById(id_leng);
	}
}
