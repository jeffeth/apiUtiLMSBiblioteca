package com.fmp.spring5.fmp.models.dao;


import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fmp.spring5.fmp.models.entity.LibroBibliografia;


public interface IBibliografiaDao extends JpaRepository<LibroBibliografia, Long> {
	
	
	  @Query(value = "select * from libro_bibliografia lb, asignatura a, usuario u  where  u.id=lb.usuariolb_id and lb.asignatura_id=a.id and u.id=:id", nativeQuery = true)
	public List<LibroBibliografia> findBibliografiasByIdUsuario(@Param("id") Long id);
	
	  // parte administrativa para listar todos los docentes con sus materias

	  @Query(value="select libro_bibliografia.id as id_bibliografia, usuario.nombre as nombre_usuario, asignatura.nombre as nombre_asignatura,\r\n" + 
	  		"libro_bibliografia.autor, libro_bibliografia.titulo, libro_bibliografia.editorial, libro_bibliografia.numero_edicion,\r\n" + 
	  		"libro_bibliografia.recurso, libro_bibliografia.serie, libro_bibliografia.url, libro_bibliografia.sugerencias, \r\n" + 
	  		"libro_bibliografia.[year]\r\n" + 
	  		"  from  usuario, usuario_asignaturas ,asignatura, libro_bibliografia\r\n" + 
	  		"where usuario.id=usuario_asignaturas.usuario_id and asignatura.id=libro_bibliografia.asignatura_id AND\r\n" + 
	  		"usuario_asignaturas.asignaturas_id=asignatura.id\r\n" + 
	  		"ORDER BY usuario.nombre", nativeQuery = true)
	  public List<?> findAllBibliografias();// eliminar despues de la primera entrega, se evaluara si se deja o se elimina
	  
	  @Query(value="select libro_bibliografia.id as id_bibliografia, usuario.nombre as nombre_usuario, asignatura.nombre as nombre_asignatura, \r\n" + 
	  		"	  		libro_bibliografia.autor, libro_bibliografia.titulo, libro_bibliografia.editorial, libro_bibliografia.numero_edicion,\r\n" + 
	  		"	  		libro_bibliografia.recurso, libro_bibliografia.serie, libro_bibliografia.url, libro_bibliografia.sugerencias,\r\n" + 
	  		"	  		libro_bibliografia.year\r\n" + 
	  		"	  		  from  usuario, usuario_asignaturas ,asignatura, libro_bibliografia, carrera \r\n" + 
	  		"	  		where usuario.id=usuario_asignaturas.usuario_id and asignatura.id=libro_bibliografia.asignatura_id AND\r\n" + 
	  		"	  		usuario_asignaturas.asignaturas_id=asignatura.id and carrera.id=asignatura.carrera_id and carrera.id=:id\r\n" + 
	  		"	  		ORDER BY usuario.nombre", nativeQuery = true)
	  public List<?> findBibliografiasByCarrera(@Param("id") Long id);
	  
	  
	  // Para guardar la bibiografia agregada por el docente
	  @Modifying
	  @Query(value="insert into libro_bibliografia (usuariolb_id,asignatura_id,autor,editorial, numero_edicion, observaciones, recurso,serie, sugerencias, titulo, url, year) "
	  		+ "values (:id_usuario, :id_asignatura, :autor, :editorial, :numero_edicion, :observaciones, :recurso, :serie, :sugerencias, :titulo, :url, :year)", nativeQuery = true)
	  public int guardarBibliografiaDocente(@Param("id_usuario") Long id_usuario, @Param("id_asignatura") Long id_asignatura,
				 @Param("autor") String autor,
				@Param("editorial") String editorial, @Param("numero_edicion") Long numero_edicion,
				@Param("observaciones") String observaciones, @Param("recurso") Long recurso,
				@Param("serie") Long serie, @Param("sugerencias") String sugerencias,
				@Param("titulo") String titulo, @Param("url") String url, @Param("year") Date year);
	  
// para mostrar datos de la bibliografia seleccionada en ventana modal
	  @Query(value="select libro_bibliografia.id as id_bibliografia, usuario.nombre as nombre_usuario, asignatura.nombre as nombre_asignatura, \r\n" + 
	  		"	  			  		libro_bibliografia.autor, libro_bibliografia.titulo, libro_bibliografia.editorial, libro_bibliografia.numero_edicion,\r\n" + 
	  		"	  			  		libro_bibliografia.recurso, libro_bibliografia.serie, libro_bibliografia.url, libro_bibliografia.sugerencias,\r\n" + 
	  		"	  			  		libro_bibliografia.year\r\n" + 
	  		"	  			  		  from  usuario, usuario_asignaturas ,asignatura, libro_bibliografia, carrera\r\n" + 
	  		"	  			  		where usuario.id=usuario_asignaturas.usuario_id and asignatura.id=libro_bibliografia.asignatura_id AND\r\n" + 
	  		"	  			  		usuario_asignaturas.asignaturas_id=asignatura.id and carrera.id=asignatura.carrera_id and libro_bibliografia.id=:id", nativeQuery = true)
	  public List<?> mostrarBibliografiaSeleccionada(@Param("id") Long id);
	  
	  // funcion para actualizar la bibliografia pero solo el admininistrador podra hacerlo
	  
	  @Modifying
	  @Query(value="update libro_bibliografia  set numero_edicion = :edicion, recurso = :recurso, serie=:serie, url=:url2, observaciones=:observaciones, sugerencias=:sugerencias  where id = :id", nativeQuery = true)
	 public int updateBibliografiasAdmin(@Param("id") Long id, @Param("edicion") Long edicion, @Param("recurso") Long recurso, @Param("serie") Long serie, 
			 @Param("url2") String url, @Param("observaciones") String observaciones, @Param("sugerencias") String sugerencias);
	
	
}
