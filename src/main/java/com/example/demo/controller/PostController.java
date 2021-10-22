package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PostDto;
import com.example.demo.model.Post;
import com.example.demo.service.PostService;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping()
	public ResponseEntity<?> showPosts() {
		return new ResponseEntity<>(postService.showIdTituloImagenCategoriaFechaDeCreacion(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/{titulo}")
	public ResponseEntity<?> showTitulo(@PathVariable String titulo) {
		return new ResponseEntity<>(postService.showTitulo(titulo), HttpStatus.ACCEPTED);
	}

	@GetMapping("/{categoria}")
	public ResponseEntity<?> showCategoria(@PathVariable String categoria) {
		return new ResponseEntity<>(postService.showCategoria(categoria), HttpStatus.ACCEPTED);
	}

	@GetMapping("/titulo/{titulo}/categoria/{categoria}")
	public ResponseEntity<?> showTituloCategoria(@PathVariable String titulo, String categoria) {
		return new ResponseEntity<>(postService.showTituloCategoria(titulo, categoria), HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> showById(@PathVariable Long id) {
		return new ResponseEntity<>(postService.showPostById(id), HttpStatus.ACCEPTED);
	}

	@PostMapping()
	public ResponseEntity<?> savePost(@RequestBody PostDto postDto) {
		Post post = postService.newPost(postDto);
		return new ResponseEntity<>(post, HttpStatus.ACCEPTED);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
		return new ResponseEntity<>(postService.replacePost(id, postDto), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePost(@PathVariable Long id) {
		postService.deletePost(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
