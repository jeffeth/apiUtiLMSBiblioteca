package com.fmp.spring5.fmp.models.services;


import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fmp.spring5.fmp.models.dao.IAsignaturaDao;
import com.fmp.spring5.fmp.models.dao.IBibliografiaDao;
import com.fmp.spring5.fmp.models.dao.ICarreraDao;
import com.fmp.spring5.fmp.models.dao.IDepartamentoDao;
import com.fmp.spring5.fmp.models.dao.IUsuarioDao;
import com.fmp.spring5.fmp.models.entity.Asignatura;
import com.fmp.spring5.fmp.models.entity.Carrera;
import com.fmp.spring5.fmp.models.entity.Departamento;
import com.fmp.spring5.fmp.models.entity.LibroBibliografia;


@Service
public class BibliografiasServiceImpl implements IBibliografiasService {

	@Autowired
    private	IBibliografiaDao biblioDao;
	
	@Autowired
	private IAsignaturaDao asignaturaDao;
	
	@Autowired
	private IDepartamentoDao deptoDao;
	
	@Autowired
	public ICarreraDao carreraDao;
	
	@Autowired
	public IUsuarioDao userDao;
	
	@Override
	@Transactional
	public List<LibroBibliografia> findAll() {

		return (List<LibroBibliografia>) biblioDao.findAll();
	}

	@Override
	@Transactional
	public LibroBibliografia save(LibroBibliografia libro) {

		return biblioDao.save(libro);
	}

	@Override
	@Transactional
	public List<Asignatura> findAllAsignaturas() {

		return asignaturaDao.findAllAsignaturas();
	}

	@Override
	@Transactional
	public List<LibroBibliografia> findBibliografiasByIdUsuario(Long id) {

		return  biblioDao.findBibliografiasByIdUsuario(id);
	}

	@Override
	@Transactional
	public List<Asignatura> findAsignaturaByUsuario(Long id) {
		// TODO Auto-generated method stub
		return asignaturaDao.findAsignaturaByUsuario(id);
	}

	@Override
	@Transactional
	public List<Departamento> findAllDepartamentos() {
		
		return deptoDao.findAllDepartamentos();
	}

	@Override
	@Transactional
	public List<Carrera> findCarreraByDepartamento(Long id) {

		return carreraDao.findCarreraByDepartamento(id);
	}

	@Override
	public List<Asignatura> findAsignaturaByCarrera(Long id) {

		return asignaturaDao.findAsignaturaByCarrera(id);
	}

	@Override
	public List<Carrera> findAllCarreras() {

		return carreraDao.findAllCarreras();
	}

	@Override
	@Transactional()
	public int guardarUsuarioAsignatura(Long id_usuario, Long id_asignatura) {

	return	userDao.guardarUsuarioAsignatura(id_usuario, id_asignatura);
		
	}

	@Override
	public List<?> findAllBibliografias() {
		return biblioDao.findAllBibliografias();
	}

	@Override
	@Transactional
	public List<?> findBibliografiasByCarrera(Long id) {// metodo que solo vera el administrador
	
		return biblioDao.findBibliografiasByCarrera(id);
	}

	@Override
	@Transactional()
	public int guardarBibliografiaDocente(Long id_usuario, Long id_asignatura, String autor, String editorial,
			Long numero_edicion, String observaciones, Long recurso, Long serie, String sugerencias, String titulo,
			String url, Date year) {

		return biblioDao.guardarBibliografiaDocente(id_usuario, id_asignatura, autor, editorial, numero_edicion, observaciones, recurso, serie, sugerencias, titulo, url, year);
	}

	@Override
	@Transactional()
	public List<?> mostrarBibliografiaSeleccionada(Long id) {

		return biblioDao.mostrarBibliografiaSeleccionada(id);
	}

	@Override
	@Transactional()
	public int updateBibliografiasAdmin(Long id, Long edicion, Long recurso, Long serie, String url, String observaciones, String sugerencias) {
		// TODO Auto-generated method stub
		return biblioDao.updateBibliografiasAdmin(id, edicion, recurso, serie, url, observaciones, sugerencias);
	}

}
