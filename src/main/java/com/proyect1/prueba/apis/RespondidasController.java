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

import com.proyect1.prueba.domain.Respondidas;
import com.proyect1.prueba.repository.RespondidasRepository;

@RestController
@RequestMapping("/apis")
public class RespondidasController {
	@Autowired
	RespondidasRepository respondidasR;

	@GetMapping("/respondidas")
	public List<Respondidas> findAll() {
		return respondidasR.findAll();
	}

	@PostMapping("/respondidas")
	public Respondidas Almacenar(@RequestBody Respondidas respondida) {
		return respondidasR.save(respondida);
	}

	@GetMapping("/respondidas/{id_respondidas}")
	public Optional<Respondidas> finid(@PathVariable int id_respondidas) {
		return respondidasR.findById(id_respondidas);
	}
}
