package com.fmp.spring5.fmp.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fmp.spring5.fmp.models.entity.Asignatura;
import com.fmp.spring5.fmp.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	
	
	public Usuario findByCorreo(String correo);// el correo es el usuario con el que inicia sesion
	
	// funcion para ingresar el usuario con la asignatura correspondiente que a seleccionado y que viene como parametros
	
	@Modifying
	@Query(
	  value = 
	    "insert into usuario_asignaturas (usuario_id, asignaturas_id) values (:id_usuario, :id_asignatura)",
	  nativeQuery = true)
	public int guardarUsuarioAsignatura(@Param("id_usuario") Long id_usuario, @Param("id_asignatura") Long id_asignatura);
	
	
	// para mostrar todos los usuarios
	/*
	 * Esta parte solo tendra acceso el super usuario el cual podra actualizar la contraseña de acceso cuando el docente o usuario normal 
	 * la olvide
	 * */
	@Query("from Usuario")
	public List<Usuario> findAllUsuarios();

	
	// ingresará la nueva contraseña
	@Modifying
	@Query(value="update usuario set password=:password2 where correo = :correo2", nativeQuery = true)
	public int actualizarPassword(@Param("correo2") String correo, @Param("password2") String password);
}
