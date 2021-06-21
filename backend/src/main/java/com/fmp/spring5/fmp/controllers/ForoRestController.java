package com.fmp.spring5.fmp.controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fmp.spring5.fmp.models.entity.Foro;
import com.fmp.spring5.fmp.models.services.IForoService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ForoRestController {

	@Autowired
	private IForoService foroService;

	@GetMapping("/foros")
	public List<Foro> index() {
		return foroService.findAll();
	}

	@GetMapping("/foros/{id}")
	public Optional<Foro> getForoById(@PathVariable("id") long id) {

		try {
			return foroService.findById(id);
		} catch (Exception e) {
			return null;
		}
	}

	// create
	@PostMapping("/foros")
	@ResponseStatus(HttpStatus.CREATED)
	public Foro create(@RequestBody Foro respuesta) {
		return foroService.save(respuesta);
	}

	// delete
	@DeleteMapping("/foros/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		foroService.delete(id);
	}
}