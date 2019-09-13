package com.djd2000.app.ws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djd2000.app.ws.UserRepository;
import com.djd2000.app.ws.io.entity.UserEntity;
import com.djd2000.app.ws.service.UserService;
import com.djd2000.app.ws.shared.Utils;
import com.djd2000.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Utils utils;

	@Override
	public UserDto createUser(UserDto user) {

		if (userRepository.findByEmail(user.getEmail()) != null)
			throw new RuntimeException("Record Already Exists");

		UserEntity userEntity = new UserEntity();
		UserDto returnValue = new UserDto();
		UserEntity storedUserDetails;
		BeanUtils.copyProperties(user, userEntity);

		userEntity.setEncryptedPassword("test");
		userEntity.setUserId(utils.generateUserid(30));

		storedUserDetails = userRepository.save(userEntity);

		BeanUtils.copyProperties(storedUserDetails, returnValue);

		return returnValue;
	}

}
