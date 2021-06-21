package com.fmp.spring5.fmp.models.services;

import java.util.List;

import com.fmp.spring5.fmp.models.entity.Noticia;





public interface INoticiaService{
public List<Noticia> findAll();
public Noticia findById(Long id);
public void delete(Long id);
public Noticia save(Noticia noticia);
}
