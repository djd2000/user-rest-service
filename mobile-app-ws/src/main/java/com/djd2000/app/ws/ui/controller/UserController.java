package com.djd2000.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.djd2000.app.ws.service.UserService;
import com.djd2000.app.ws.shared.dto.UserDto;
import com.djd2000.app.ws.ui.model.request.UserDetailsRequestModel;
import com.djd2000.app.ws.ui.model.response.UserRest;

@RequestMapping("users") // http://localhost:8080/users
@RestController
public class UserController {

	@Autowired
	UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public String getUser() {
		return "get user was called";
	}

	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {

		UserRest returnValue = new UserRest();

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userDetails, userDto);

		UserDto createdUser;
		createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);

		return returnValue;

	}

	@PutMapping
	public String updateUser() {
		return "update user was called";

	}

	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";

	}

}
