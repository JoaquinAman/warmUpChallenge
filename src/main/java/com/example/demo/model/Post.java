package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Data
@Table(name = "Post")
@SQLDelete(sql = "UPDATE Post SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "contenido")
	private String contenido;

	@Column(name = "imagen")
	private String imagen;

	@Column(name = "categoria")
	private String categoria;

	@Column(name = "fechaDeCreacion")
	private Date fechaDeCreacion;

	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user_id;

	public Post() {
	}

	public Post(String titulo, String contenido, String imagen, String categoria, Date fechaDeCreacion, User user_id) {

		this.titulo = titulo;
		this.contenido = contenido;
		this.imagen = imagen;
		this.categoria = categoria;
		this.fechaDeCreacion = fechaDeCreacion;
		this.user_id = user_id;
	}

	public Post(Long id, String titulo, String imagen, String categoria, Date fechaDeCreacion) {

		this.id = id;
		this.titulo = titulo;
		this.imagen = imagen;
		this.categoria = categoria;
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public Post(String titulo, String imagen, String categoria, Date fechaDeCreacion) {

		this.titulo = titulo;
		this.imagen = imagen;
		this.categoria = categoria;
		this.fechaDeCreacion = fechaDeCreacion;
	}
}
