package com.fmp.spring5.fmp.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fmp.spring5.fmp.models.entity.Video;




public interface IVideoDao extends CrudRepository<Video, Long>{

}
