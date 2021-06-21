package com.fmp.spring5.fmp.models.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="indice_video")
public class indice_video implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tema_padre;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTema_padre() {
		return tema_padre;
	}
	public void setTema_padre(String tema_padre) {
		this.tema_padre = tema_padre;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
