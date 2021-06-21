package com.fmp.spring5.fmp.models.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmp.spring5.fmp.models.dao.IindiceVideoDao;
import com.fmp.spring5.fmp.models.entity.indice_video;


@Service
public class IndiceVideoServiceImplement implements IindiceVideoService {

	@Autowired
	private IindiceVideoDao videoDao;

	@Override
	@Transactional(readOnly = true)
	public List<indice_video> findAll() {
		return (List<indice_video>) videoDao.findAll();
	}

}
