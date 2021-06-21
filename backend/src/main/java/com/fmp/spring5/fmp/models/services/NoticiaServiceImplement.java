package com.fmp.spring5.fmp.models.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmp.spring5.fmp.models.dao.INoticiaDao;
import com.fmp.spring5.fmp.models.entity.Noticia;


@Service
public class NoticiaServiceImplement implements INoticiaService{

	@Autowired
	private INoticiaDao noticiaDao;
	@Override
	@Transactional(readOnly = true)
	public List<Noticia> findAll() {
		return (List<Noticia>) noticiaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Noticia findById(Long id) {
		// TODO Auto-generated method stub
		return noticiaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Noticia save(Noticia noticia) {
		// TODO Auto-generated method stub
		return noticiaDao.save(noticia);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		noticiaDao.deleteById(id);
	}
}
