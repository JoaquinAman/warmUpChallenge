package com.example.demo.builder;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

import lombok.Data;

@Data
public class UserBuilder {

	private String mail;
	private String password;

	public UserBuilder withUsuarioDto(UserDto userDto) {

		this.mail = userDto.getMail();

		this.password = userDto.getPassword();
		return this;
	}

	public User build() {
		return new User(this.mail, this.password);
	}
}
