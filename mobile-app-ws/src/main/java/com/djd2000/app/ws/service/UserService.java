package com.djd2000.app.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.djd2000.app.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{

	public UserDto createUser(UserDto userDto) ;

}
