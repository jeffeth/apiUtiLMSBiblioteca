package com.fmp.spring5.fmp.controllers;

import java.io.UnsupportedEncodingException;


import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fmp.spring5.fmp.models.services.NotificationService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController

public class mailRestController {

	private Logger logger = LoggerFactory.getLogger(mailRestController.class);

	@Autowired
	private NotificationService notifService;

	@RequestMapping("/notification/foro/{tema}")
	public void notiforo(@PathVariable("tema") String tema) throws MessagingException, JsonProcessingException {
		try {
			notifService.sendNotificationForo(tema);
		} catch (MailException e) {
			logger.info("Error enviando mensaje: " + e.getMessage());
		}
	}

	@RequestMapping("/notification/respuesta/{emisor}/{id}/{tema}/{respuesta}")
	public void notiresp(@PathVariable("emisor") String emisor, @PathVariable("id") String id,
			@PathVariable("tema") String tema, @PathVariable("respuesta") String respuesta) throws UnsupportedEncodingException, MessagingException {
		try {
			notifService.sendNotificationRespuesta(emisor, id, tema, respuesta);
		} catch (MailException e) {
			logger.info("Error enviando mensaje: " + e.getMessage());
		}
	}

}