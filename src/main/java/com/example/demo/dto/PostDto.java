package com.example.demo.dto;

import java.util.Date;

import com.example.demo.model.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {

	private String titulo;
	private String contenido;
	private String imagen;
	private String categoria;
	private Date fechaDeCreacion;
	private User user_id;
}
