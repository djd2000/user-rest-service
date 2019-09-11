package com.djd2000.app.ws.service;

import org.springframework.stereotype.Service;

import com.djd2000.app.ws.model.User;
import com.djd2000.app.ws.repositories.UserRepository;
import com.djd2000.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		user = userRepository.save(user);
		
		UserDto returnDto = new UserDto();
		returnDto.setFirstName(user.getFirstName());
		returnDto.setLastName(user.getLastName());
		
		return returnDto;
	}

}
