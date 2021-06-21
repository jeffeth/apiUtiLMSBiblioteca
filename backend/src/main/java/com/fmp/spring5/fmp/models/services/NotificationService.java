package com.fmp.spring5.fmp.models.services;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fmp.spring5.fmp.models.entity.Usuario;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class NotificationService {
	@Autowired
	private JavaMailSender javaMailSender;

	
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Autowired
	private TemplateEngine templateEngine;

	//Envia noficicación al registrar un nuevo foro
	public void sendNotificationForo(String tema) throws MailException, MessagingException, JsonProcessingException {

		//Usuario[] usuario = getMailUsers();
		Usuario usuario = new Usuario();
		//usuario.setUsuario("cc16125@ues.edu.sv");
		usuario.setCorreo("josue1415@yahoo.es");
		final Context ctx = new Context();
		ctx.setVariable("user", "Josué");
		ctx.setVariable("temaForo", tema);

		final MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		message.setSubject("Nuevo foro creado");
		message.setFrom("forofmp@gmail.com");
		//String correos = "";
		//for (Usuario u : usuario) {
		//	correos = correos + u.getUsuario() + ",";
		//}
		//message.setTo(correos);
		message.setTo(usuario.getCorreo());
		// Create the HTML body using Thymeleaf
		final String htmlContent = this.templateEngine.process("mailTemplateForo.html", ctx);
		message.setText(htmlContent, true); // true = isHtml
		
		// Send mail
		this.javaMailSender.send(mimeMessage);
	}

	//Send notification to admin and user(teacher)
	public void sendNotificationRespuesta(String emisor, String id, String tema, String respuesta)
			throws MailException, UnsupportedEncodingException, MessagingException {
		
		Usuario usuario = new Usuario();
		usuario.setCorreo("cc16125@ues.edu.sv");
		final MimeMessage mimeMessage2 = this.javaMailSender.createMimeMessage();
		final MimeMessageHelper message2 = new MimeMessageHelper(mimeMessage2, true, "UTF-8");
		message2.setSubject("Nueva respuesta añadida por " + emisor);
		message2.setFrom("forofmp@gmail.com");
		message2.setTo(new String[]{usuario.getCorreo(), "josue1415@yahoo.es"});
		String encodedParam = URLEncoder.encode(id, "UTF-8");
		String urlToClic = "http://localhost:4200/foros_respuestas/" + encodedParam + "/1";

		String RespuestaDecoded = new String(Base64.getDecoder().decode(respuesta));
		final Context ctx2 = new Context();
		ctx2.setVariable("emisor", "Josué");
		ctx2.setVariable("url", urlToClic);
		ctx2.setVariable("tema", tema);
		ctx2.setVariable("respuesta", RespuestaDecoded);

		// Create the HTML body using Thymeleaf
		final String htmlContent = this.templateEngine.process("mailTemplateRespuestas.html", ctx2);
		message2.setText(htmlContent, true); // true = isHtml

		// Send mail
		this.javaMailSender.send(mimeMessage2);

	}

	public static void getEmployees() {
		final String uri = "http://localhost:8080/api/usuarios";

		RestTemplate restTemplate = new RestTemplate();

		Usuario result = restTemplate.getForObject(uri, Usuario.class);
		System.out.println(result);
	}

	public static Usuario[] getMailUsers() throws JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Usuario[]> response = restTemplate.getForEntity("http://localhost:8080/api/usuarios",
				Usuario[].class);
		Usuario[] users = response.getBody();
		return users;
	}
}
