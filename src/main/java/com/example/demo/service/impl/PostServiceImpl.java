package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.builder.PostBuilder;
import com.example.demo.dto.PostDto;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> showIdTituloImagenCategoriaFechaDeCreacion() {

		return postRepository.findAllByOrderByFechaCreacionDesc();
	}

	@Override
	public List<Post> showTitulo(String titulo) {

		return postRepository.findByTitulo(titulo);
	}

	@Override
	public List<Post> showCategoria(String categoria) {

		return postRepository.findByCategoria(categoria);
	}

	@Override
	public List<Post> showTituloCategoria(String titulo, String categoria) {

		return postRepository.findByTituloAndCategoria(titulo, categoria);
	}

	@Override
	public Post showPostById(Long id) {
		Post post = postRepository.findById(id).get();
		return post;
	}

	@Override
	public Post newPost(PostDto postDto) {
		Post post = new PostBuilder().withPostDto(postDto).build();
		return postRepository.save(post);
	}

	@Override
	public Post replacePost(Long id, PostDto postDto) {
		Post post = postRepository.findById(id).get();
		post = new PostBuilder().withPostDto(postDto).edit(post);
		return null;
	}

	@Override
	public void deletePost(Long id) {
		postRepository.deleteById(id);

	}

}
