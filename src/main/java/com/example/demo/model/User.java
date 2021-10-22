package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "mail")
	private String mail;

	@Column(name = "password")
	private String password;

	@OneToMany(/* mappedBy = "user_id", */ targetEntity = Post.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Post> posts;

	public User() {
	}

	public User(String mail, String password, List<Post> posts) {

		this.mail = mail;
		this.password = password;
		this.posts = posts;
	}

	public User(String mail, String password) {

		this.mail = mail;
		this.password = password;

	}
}
