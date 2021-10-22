package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	@Query("select post.id, post.titulo, post.imagen, post.categoria, post.fechaDeCreacion from Post post ORDER BY post.fechaDeCreacion DESC")
	List<Post> findAllByOrderByFechaCreacionDesc();

	List<Post> findByTitulo(String titulo);

	List<Post> findByCategoria(String categoria);

	List<Post> findByTituloAndCategoria(String titulo, String categoria);
}
