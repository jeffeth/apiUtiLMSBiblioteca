package com.fmp.spring5.fmp.models.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmp.spring5.fmp.models.dao.IVideoDao;
import com.fmp.spring5.fmp.models.entity.Video;


@Service
public class VideoServiceImplement implements IVideoService {

	@Autowired
	private IVideoDao videoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Video> findAll() {
		return (List<Video>) videoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Video findById(Long id) {
		// TODO Auto-generated method stub
		return videoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Video save(Video video) {
		// TODO Auto-generated method stub
		return videoDao.save(video);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		videoDao.deleteById(id);

	}

}
