package com.fmp.spring5.fmp.models.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;

@Entity

public class LibroBibliografia implements Serializable {
	
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	
	private String autor;
	
	@Temporal(TemporalType.DATE)
	private Date year;
	
	private String titulo;
	
	private int numeroEdicion;
	
	private String editorial;
	
	private int serie;
	
	private String url;
	
	private int recurso; // 1: libro, 2: tesis, 3: revista, 4: capitulo de libro
	
	private String sugerencias;// sugerencias de libros
	
	private String observaciones;

	@NotNull()
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="asignatura_id")
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	
	private Asignatura asignatura;
	
	@NotNull()
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuariolb_id")
	@JsonIgnore(value = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	
	private Usuario usuario;
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getYear() {
		
		 SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
	        String currentYear = getYearFormat.format(year);
		return currentYear;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumeroEdicion() {
		return numeroEdicion;
	}

	public void setNumeroEdicion(int numeroEdicion) {
		this.numeroEdicion = numeroEdicion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getRecurso() {
		return recurso;
	}

	public void setRecurso(int recurso) {
		this.recurso = recurso;
	}

	public String getSugerencias() {
		return sugerencias;
	}

	public void setSugerencias(String sugerencias) {
		this.sugerencias = sugerencias;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	
	
	
	
	

}
