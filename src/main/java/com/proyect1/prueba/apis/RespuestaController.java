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
import com.proyect1.prueba.domain.Respuesta;
import com.proyect1.prueba.repository.RespuestaRepository;

@RestController
@RequestMapping("/apis")
public class RespuestaController {
	@Autowired
	RespuestaRepository respuestar;

	@GetMapping("/respuestas")
	public List<Respuesta> findAll() {
		return respuestar.findAll();
	}
	@PostMapping("/respuestas")
	public Respuesta guardar(@RequestBody Respuesta respuesta) {
		return respuestar.save(respuesta);
	}
	@GetMapping("/respuestas/{id_respuesta}")
	public Optional<Respuesta> findid(@PathVariable int id_respuesta) {
		return respuestar.findById(id_respuesta);
	}
}
