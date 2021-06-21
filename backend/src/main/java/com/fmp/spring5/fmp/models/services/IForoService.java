package com.fmp.spring5.fmp.models.services;

import java.util.List;

import java.util.Optional;

import com.fmp.spring5.fmp.models.entity.Foro;



public interface IForoService {
public List<Foro> findAll();
public Optional<Foro> findById(Long id);
public Foro save(Foro foro);
public void delete(Long id);
}
