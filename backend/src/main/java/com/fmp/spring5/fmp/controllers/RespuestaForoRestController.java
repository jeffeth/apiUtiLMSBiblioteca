package com.fmp.spring5.fmp.controllers;

import java.util.List;


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

import com.fmp.spring5.fmp.models.entity.RespuestaForo;
import com.fmp.spring5.fmp.models.services.IForoRespuestaService;



@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class RespuestaForoRestController {

	@Autowired
	private IForoRespuestaService respuestaService;

	@GetMapping("/respuestas")
	public List<RespuestaForo> index() {
		return respuestaService.findAll();
	}

	@GetMapping("/respuestas/{id}")
	public List<RespuestaForo> getRespuestasById(@PathVariable("id") long id) {

		try {
			return respuestaService.getRespuestaByForoId(id);
		} catch (Exception e) {
			return null;
		}
	}

	// create
	@PostMapping("/respuestas")
	@ResponseStatus(HttpStatus.CREATED)
	public RespuestaForo create(@RequestBody RespuestaForo respuesta) {
		return respuestaService.save(respuesta);
	}

	// delete
	@DeleteMapping("/respuestas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		respuestaService.delete(id);
	}
}
