package com.fmp.spring5.fmp.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "NOTICIAS")
public class Noticia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	@Column(length = 250)
	private String tema;
	private String img_principal;
	@Column(length = 10000)
	private String contenido;

	public Noticia(Date createAt, String tema, String img_principal, String contenido) {
		super();
		this.createAt = createAt;
		this.tema = tema;
		this.img_principal = img_principal;
		this.contenido = contenido;
	}

	public Noticia(Long id, Date createAt, String tema, String img_principal, String contenido) {
		super();
		this.id = id;
		this.createAt = createAt;
		this.tema = tema;
		this.img_principal = img_principal;
		this.contenido = contenido;
	}

	public Noticia() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getImg_principal() {
		return img_principal;
	}

	public void setImg_principal(String img_principal) {
		this.img_principal = img_principal;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

}
