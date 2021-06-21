package com.fmp.spring5.fmp.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmp.spring5.fmp.models.entity.indice_video;
import com.fmp.spring5.fmp.models.services.IindiceVideoService;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class IndiceVideoRestController {
	
	@Autowired
	private IindiceVideoService videoService;
	
	@GetMapping("/indice_video")
	public List<indice_video> index() {
		return videoService.findAll();
	}
}
