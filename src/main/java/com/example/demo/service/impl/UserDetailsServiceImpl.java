package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.builder.UserBuilder;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		UserBuilder userBuilder = null;
		if (user != null) {
//			userBuilder = User.withUsername(username);
//			userBuilder.disabled(false);
			userBuilder.setPassword(user.getPassword());
//			userBuilder.authorities(new SimpleGrantedAuthority("ROL_USER"));
		} else {
			throw new UsernameNotFoundException("Usuario no registrado");
		}
		return (UserDetails) userBuilder.build();
	}
}
