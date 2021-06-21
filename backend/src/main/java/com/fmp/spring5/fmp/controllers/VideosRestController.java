package com.fmp.spring5.fmp.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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

import com.fmp.spring5.fmp.models.entity.Video;
import com.fmp.spring5.fmp.models.services.IVideoService;

import org.springframework.http.HttpStatus;



@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class VideosRestController {

	@Autowired
	private IVideoService videoService;

	@GetMapping("/videos")
	public List<Video> index() {
		return videoService.findAll();
	}

	@GetMapping("/videos/{id}")
	public Video getVideosById(@PathVariable("id") long id) {

		try {
			return videoService.findById(id);
		} catch (Exception e) {
			return null;
		}
	}

	// create
	@PostMapping("/videos")
	@ResponseStatus(HttpStatus.CREATED)
	public Video create(@RequestBody Video noticia) {
		return videoService.save(noticia);
	}

	// update
	@PutMapping("/videos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Video update(@RequestBody Video video, @PathVariable Long id) {
		Video noticiaActual = videoService.findById(id);

		noticiaActual.setTema(video.getTema());
		noticiaActual.setEnlace(video.getEnlace());
		noticiaActual.setDescripcion(video.getDescripcion());

		return videoService.save(noticiaActual);
	}

	// delete
	@DeleteMapping("/videos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		videoService.delete(id);
	}
}
