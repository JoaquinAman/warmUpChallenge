package com.example.demo.builder;

import java.util.Date;

import com.example.demo.dto.PostDto;
import com.example.demo.model.Post;
import com.example.demo.model.User;

public class PostBuilder {

	private String titulo;
	private String contenido;
	private String imagen;
	private String categoria;
	private Date fechaDeCreacion;
	private User user_id;

	public PostBuilder withPostDto(PostDto postDto) {
		this.titulo = postDto.getTitulo();
		this.contenido = postDto.getContenido();
		this.imagen = postDto.getImagen();
		this.categoria = postDto.getCategoria();
		this.fechaDeCreacion = postDto.getFechaDeCreacion();
		this.user_id = postDto.getUser_id();
		return this;
	}

	public Post build() {
		return new Post(this.titulo, this.contenido, this.imagen, this.categoria, this.fechaDeCreacion, this.user_id);
	}

	public Post edit(Post post) {
		post.setTitulo(titulo);
		post.setContenido(contenido);
		post.setImagen(imagen);
		post.setCategoria(categoria);
		post.setFechaDeCreacion(fechaDeCreacion);
		post.setUser_id(user_id);
		return post;
	}
}
