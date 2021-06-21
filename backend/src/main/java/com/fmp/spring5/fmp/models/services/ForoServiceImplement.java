package com.fmp.spring5.fmp.models.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fmp.spring5.fmp.models.dao.IForoDao;
import com.fmp.spring5.fmp.models.entity.Foro;


@Service
public class ForoServiceImplement implements IForoService {

	@Autowired
	private IForoDao foroDao;

	@Override
	@Transactional(readOnly = true)
	public List<Foro> findAll() {
		return (List<Foro>) foroDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Foro> findById(Long id) {
		// TODO Auto-generated method stub
		return foroDao.findById(id);
	}

	@Override
	@Transactional
	public Foro save(Foro foro) {
		// TODO Auto-generated method stub
		return foroDao.save(foro);
	}
	
	// delete
		@DeleteMapping("/respuestas/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			foroDao.deleteById(id);
		}

}
