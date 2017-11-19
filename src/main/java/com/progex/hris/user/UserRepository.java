package com.progex.hris.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findByUserName(String userName);
}
