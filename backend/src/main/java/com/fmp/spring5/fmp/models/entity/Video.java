package com.fmp.spring5.fmp.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class Video implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tema;
	@Column(length = 10000)
	private String descripcion;
	private String enlace;

	@ManyToOne
	private indice_video indice_video;

	public Video(Long id, String tema, String descripcion, String enlace) {
		super();
		this.id = id;
		this.tema = tema;
		this.descripcion = descripcion;
		this.enlace = enlace;
	}

	public Video() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public indice_video getIndice_video() {
		return indice_video;
	}

	public void setIndice_video(indice_video indice_video) {
		this.indice_video = indice_video;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
