package com.fmp.spring5.fmp.models.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmp.spring5.fmp.models.dao.IRespuestaForoDao;
import com.fmp.spring5.fmp.models.entity.Foro;
import com.fmp.spring5.fmp.models.entity.RespuestaForo;



@Service
public class RespuestaForoServiceImplement implements IForoRespuestaService {

	@Autowired
	private IRespuestaForoDao respuestaDao;

	@Override
	@Transactional(readOnly = true)
	public List<RespuestaForo> findAll() {
		return (List<RespuestaForo>) respuestaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<RespuestaForo> findById(Long id) {
		return respuestaDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<RespuestaForo> findByForoId(Foro foro) {
		// TODO Auto-generated method stub
		return respuestaDao.findByForoId(foro);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RespuestaForo> getRespuestaByForoId(Long id) {
		// TODO Auto-generated method stub
		return respuestaDao.getRespuestaByForoId(id);
	}

	@Override
	@Transactional
	public RespuestaForo save(RespuestaForo noticia) {
		// TODO Auto-generated method stub
		return respuestaDao.save(noticia);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		respuestaDao.deleteById(id);
		
	}
	
}
