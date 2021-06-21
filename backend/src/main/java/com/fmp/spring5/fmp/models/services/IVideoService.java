package com.fmp.spring5.fmp.models.services;

import java.util.List;

import com.fmp.spring5.fmp.models.entity.Video;




public interface IVideoService {
public List<Video> findAll();
public Video findById(Long id);
public Video save(Video video);
public void delete(Long id);
}
