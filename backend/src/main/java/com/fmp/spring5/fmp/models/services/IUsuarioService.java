package com.fmp.spring5.fmp.models.services;

import java.util.List;

import com.fmp.spring5.fmp.models.entity.Usuario;

public interface IUsuarioService  {
	
	public Usuario findByCorreo(String correo);// el correo es el usuario con el que inicia sesion
	
	// Muestra los usuarios, leer comment del dao
	public List<Usuario> findAllUsuarios();
	
	public int actualizarPassword(String correo, String password);

}
