package com.fmp.spring5.fmp.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fmp.spring5.fmp.models.entity.Asignatura;
import com.fmp.spring5.fmp.models.entity.Carrera;
import com.fmp.spring5.fmp.models.entity.Departamento;
import com.fmp.spring5.fmp.models.entity.LibroBibliografia;
import com.fmp.spring5.fmp.models.entity.Usuario;
import com.fmp.spring5.fmp.models.services.IBibliografiasService;
import com.fmp.spring5.fmp.models.services.IUsuarioService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class BibliografiaRestController {
	@Autowired
	private IBibliografiasService ibService;
	
	@Autowired
	private IUsuarioService user;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Secured("ROLE_DOCENTE")
	@GetMapping("/libros/{id}")
	public List<LibroBibliografia> index(@PathVariable Long id){
		
		return ibService.findBibliografiasByIdUsuario(id);
	}
	
	@Secured("ROLE_DOCENTE")
	@PostMapping("/libros")
	@ResponseStatus(HttpStatus.CREATED)
	public LibroBibliografia create(@RequestBody LibroBibliografia libro) {
		
		return ibService.save(libro);
	}
	@Secured("ROLE_DOCENTE")
	@GetMapping("/libros/asignatura")
	public List<Asignatura> listarAsignaturas(){
		
		return ibService.findAllAsignaturas();
	}
	
	@GetMapping("/libros/asignatura/{id}")
	public List<Asignatura> listarAsignaturaByUsuario(@PathVariable Long id){
		return ibService.findAsignaturaByUsuario(id);
	}
	
	@GetMapping("/libros/departamentos")
	public List<Departamento> listarDepartamentos(){
		return ibService.findAllDepartamentos();
	}
	
	@GetMapping("/libros/carreras/{id}")
	public List<Carrera> listarCarrerasByDepartamento(@PathVariable Long id){
		return ibService.findCarreraByDepartamento(id);
	}
	@GetMapping("/libros/carreras")
	public List<Carrera> listarCarreras(){
		return ibService.findAllCarreras();
	}
	
	@GetMapping("/libros/carrera/asignatura/{id}")
	public List<Asignatura> listarAsignaturasByCarrera(@PathVariable Long id){
		return ibService.findAsignaturaByCarrera(id);
	}
	
	@PostMapping("/libros/registrar_asignatura")
	
	public int guardarUsuarioAsignaturas(@RequestParam("id_usuario") Long id_usuario, @RequestParam("id_asignatura") Long id_asignatura) {
	return	ibService.guardarUsuarioAsignatura(id_usuario, id_asignatura);
	}
	
	@GetMapping("/bibliografias")
	public List<?> findAllBibliografias(){
		return ibService.findAllBibliografias();
	}
	// funcion que lista las bibliografias registradas por todos los docentes, obteniendolas por el id de la carrera para listarlas
	@Secured("ROLE_ADMIN")
	@GetMapping("/bibliografias/{id}")
	 public List<?> findBibliografiasByCarrera(@PathVariable Long id){
		return ibService.findBibliografiasByCarrera(id);
	}
	
	@PostMapping("/libros/guardarb")
	public int guardarBibliografiaDocente(@RequestParam("id_usuario") Long id_usuario, @RequestParam("id_asignatura") Long id_asignatura,
			 @RequestParam("autor") String autor,
			@RequestParam("editorial") String editorial, @RequestParam("numero_edicion") Long numero_edicion,
			@RequestParam("observaciones") String observaciones, @RequestParam("recurso") Long recurso,
			@RequestParam("serie") Long serie, @RequestParam("sugerencias") String sugerencias,
			@RequestParam("titulo") String titulo, @RequestParam("url") String url, @RequestParam("year") String year) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		Date date=null;
		try {
			 date = formatter.parse(year);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ibService.guardarBibliografiaDocente(id_usuario, id_asignatura, autor, editorial, numero_edicion, observaciones, recurso, serie, sugerencias, titulo, url, date);
	}
	
	@GetMapping("/libros/mostrarseleccionada/{id}")
	public List<?> mostarBibliografiaSeleccionada(@PathVariable Long id){
		return ibService.mostrarBibliografiaSeleccionada(id);
	}
	
	@PostMapping("/libros/updateAdmin")
	public int updateBibliografiasAdmin(@RequestParam("id") Long id, @RequestParam("edicion") Long edicion, @RequestParam("recurso") Long recurso, @RequestParam("serie") Long serie,
			@RequestParam("url") String url, @RequestParam("observaciones") String observaciones, @RequestParam("sugerencias") String sugerencias	) {
		return ibService.updateBibliografiasAdmin(id, edicion, recurso, serie, url, observaciones, sugerencias);
	}
	
	
	@GetMapping("/usuarios")
	public List<Usuario> findAllUsuarios(){
		return user.findAllUsuarios();
	}
	
	@PostMapping("/usuarios/password")
	public int actualizarPassword(@RequestParam("correo") String correo, @RequestParam("password") String password) {
		
		return user.actualizarPassword(correo, passwordEncoder.encode(password));
	}
	

}
