package com.fmp.spring5.fmp.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fmp.spring5.fmp.models.entity.Noticia;
import com.fmp.spring5.fmp.models.services.INoticiaService;



@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class NoticiaRestController {

	@Autowired
	private INoticiaService noticiaService;

	//get All
	@GetMapping("/noticias")
	public List<Noticia> index() {
		return noticiaService.findAll();
	}

	//get by id
	@GetMapping("/noticias/{id}")
	public Noticia getVideosById(@PathVariable("id") long id) {

		try {
			return noticiaService.findById(id);
		} catch (Exception e) {
			return null;
		}
	}

	//create
	@Secured("ROLE_LMSADMIN")
	@PostMapping("/noticias")
	@ResponseStatus(HttpStatus.CREATED)
	public Noticia create(@RequestBody Noticia noticia) {
		return noticiaService.save(noticia);
	}

	//update
	@PutMapping("/noticias/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Noticia update(@RequestBody Noticia noticia, @PathVariable Long id) {
		Noticia noticiaActual = noticiaService.findById(id);

		noticiaActual.setTema(noticia.getTema());
		noticiaActual.setImg_principal(noticia.getImg_principal());
		noticiaActual.setContenido(noticia.getContenido());

		return noticiaService.save(noticiaActual);
	}

	//delete
	@DeleteMapping("/noticias/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		noticiaService.delete(id);
	}

	/*
	 * @PostMapping("/") public ResponseEntity<Noticia> createTutorial(@RequestBody
	 * tutorial) { try { _tutorial = noticiaService .save(new
	 * (tutorial.getCreateAt(), tutorial.getTema(), tutorial.getImg_principal(),
	 * tutorial.getContenido())); return new ResponseEntity<>(_tutorial,
	 * HttpStatus.CREATED); } catch (Exception e) { return new
	 * ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
}
