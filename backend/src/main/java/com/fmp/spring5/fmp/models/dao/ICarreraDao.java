package com.fmp.spring5.fmp.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fmp.spring5.fmp.models.entity.Carrera;

public interface ICarreraDao extends CrudRepository<Carrera, Long>{

	@Query(value="SELECT * from departamento d, carrera c\r\n" + 
			"where d.id=c.departamento_id and d.id=:id",nativeQuery = true)
	public List<Carrera> findCarreraByDepartamento(@Param("id") Long id);
	
	@Query("from Carrera")
	public List<Carrera> findAllCarreras();
}
