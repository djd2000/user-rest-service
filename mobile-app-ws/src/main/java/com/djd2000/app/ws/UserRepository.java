package com.djd2000.app.ws;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.djd2000.app.ws.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	UserEntity findByEmail(String email);

}
