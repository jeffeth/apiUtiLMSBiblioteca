package com.fmp.spring5.fmp.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmp.spring5.fmp.models.dao.IUsuarioDao;
import com.fmp.spring5.fmp.models.entity.Usuario;
import com.sun.istack.logging.Logger;

@Service
public class UsuarioService implements IUsuarioService,UserDetailsService {
	
	//private Logger log =  LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)// solo sera de lectura ya que los datos seran desde la bd y asi no se permite la obtencion indebida de contraseñas
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

		Usuario usuario = usuarioDao.findByCorreo(correo);
		
		// se validad que el usuario este en la bd al hacer inicio de sesion
		if(usuario==null) {
				//((org.slf4j.Logger) log).error("Error en el inicio de sesion corro o contraseña incorrectos, o su usuario no existe");
				throw new UsernameNotFoundException("Error el correo no existe");
		}
		
		List<GrantedAuthority> autorizacion = usuario.getRoles().stream().map(
				role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());// variable que autoriza el inicio de sesion
		
		return new User(usuario.getCorreo(), usuario.getPassword(), usuario.getHabilitado(), true, true, true, autorizacion);
	}

	@Override
	public Usuario findByCorreo(String correo) {

		return usuarioDao.findByCorreo(correo);
	}

	// obtiene todos los usuarios, leer comment del dao
	@Override
	@Modifying
	@Transactional(readOnly = true)
	public List<Usuario> findAllUsuarios() {

		return usuarioDao.findAllUsuarios();
	}

	@Override
	@Modifying
	@Transactional
	public int actualizarPassword(String correo, String password) {

		return usuarioDao.actualizarPassword(correo, password);
	}
	
	

}
