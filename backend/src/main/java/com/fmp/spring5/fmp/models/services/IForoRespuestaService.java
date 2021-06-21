package com.fmp.spring5.fmp.models.services;

import java.util.List;

import java.util.Optional;

import com.fmp.spring5.fmp.models.entity.Foro;
import com.fmp.spring5.fmp.models.entity.RespuestaForo;


public interface IForoRespuestaService {
public List<RespuestaForo> findAll();
public Optional<RespuestaForo> findById(Long id);
public Optional<RespuestaForo> findByForoId(Foro foro);
public List<RespuestaForo> getRespuestaByForoId(Long id);
public RespuestaForo save(RespuestaForo noticia);
public void delete(Long id);
}
