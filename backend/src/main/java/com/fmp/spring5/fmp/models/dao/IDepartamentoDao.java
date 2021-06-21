package com.fmp.spring5.fmp.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fmp.spring5.fmp.models.entity.Departamento;

public interface IDepartamentoDao extends CrudRepository<Departamento, Long>{
	
	@Query("from Departamento")
	public List<Departamento> findAllDepartamentos();
	

}
