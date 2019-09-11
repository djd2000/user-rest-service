package com.djd2000.app.ws.repositories;

import org.springframework.data.repository.CrudRepository;

import com.djd2000.app.ws.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
