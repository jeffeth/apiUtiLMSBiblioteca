package com.fmp.spring5.fmp.models.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fmp.spring5.fmp.models.entity.Foro;
import com.fmp.spring5.fmp.models.entity.RespuestaForo;



public interface IRespuestaForoDao extends CrudRepository<RespuestaForo, Long>{
	public Optional<RespuestaForo> findByForo(Long id);
	public Optional<RespuestaForo> findByForoId(Foro foro);
	@Query(value="select * from resp_foro r where r.foro_id= :id", nativeQuery=true)
    List<RespuestaForo> getRespuestaByForoId(Long id);
}
