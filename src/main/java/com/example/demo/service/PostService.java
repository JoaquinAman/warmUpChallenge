package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PostDto;
import com.example.demo.model.Post;

public interface PostService {

	public List<Post> showIdTituloImagenCategoriaFechaDeCreacion();

	public List<Post> showTitulo(String titulo);

	public List<Post> showCategoria(String titulo);

	public List<Post> showTituloCategoria(String titulo, String Categoria);

	public Post showPostById(Long id);

	public Post newPost(PostDto postDto);

	public Post replacePost(Long id, PostDto postDto);

	public void deletePost(Long id);
}
