package com.fmp.spring5.fmp.models.services;


import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.repository.query.Param;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fmp.spring5.fmp.models.entity.Asignatura;
import com.fmp.spring5.fmp.models.entity.Carrera;
import com.fmp.spring5.fmp.models.entity.Departamento;
import com.fmp.spring5.fmp.models.entity.LibroBibliografia;


public interface IBibliografiasService {

	public List<LibroBibliografia> findAll();
	
	public LibroBibliografia save(LibroBibliografia libro);
	
	public List<Asignatura> findAllAsignaturas();
	
	public List<Asignatura> findAsignaturaByUsuario(Long id);
	
	public List<LibroBibliografia> findBibliografiasByIdUsuario(Long id);
	
	public List<Departamento> findAllDepartamentos();
	
	public List<Carrera> findCarreraByDepartamento(Long id);
	
	public List<Asignatura> findAsignaturaByCarrera(Long id);
	
	public List<Carrera> findAllCarreras();
	
	public int guardarUsuarioAsignatura(Long id_usuario, Long id_asignatura);
	
	public List<?> findAllBibliografias();
	
	 public List<?> findBibliografiasByCarrera(Long id);
	 
	 public int guardarBibliografiaDocente( Long id_usuario, Long id_asignatura,
			 String autor,
			 String editorial, Long numero_edicion,
			String observaciones,  Long recurso,
			 Long serie,  String sugerencias,
			 String titulo,  String url,  Date year);
	 
	 public List<?> mostrarBibliografiaSeleccionada(Long id);
	 
	 public int updateBibliografiasAdmin(Long id, Long edicion, Long recurso, Long serie, String url, String observaciones, String sugerencias);
}
