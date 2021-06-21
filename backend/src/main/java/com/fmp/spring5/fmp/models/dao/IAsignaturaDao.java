package com.fmp.spring5.fmp.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fmp.spring5.fmp.models.entity.Asignatura;


public interface IAsignaturaDao extends CrudRepository<Asignatura, Long> {
	
	@Query("from Asignatura")
	public List<Asignatura> findAllAsignaturas();
	
	@Query(value="select * from asignatura a, usuario_asignaturas ua, usuario u where a.id=ua.asignaturas_id and ua.usuario_id=u.id and u.id=:id", nativeQuery = true)
	public List<Asignatura> findAsignaturaByUsuario(@Param("id") Long id);
	
	@Query(value="select * from asignatura a, carrera c\r\n" + 
			"where a.carrera_id=c.id and c.id=:carrera_id",nativeQuery = true)
	public List<Asignatura> findAsignaturaByCarrera(@Param("carrera_id") Long id);

}
