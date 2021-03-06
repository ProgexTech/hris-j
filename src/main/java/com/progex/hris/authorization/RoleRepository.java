package com.progex.hris.authorization;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Short>{

	public Role findByType(String type);
} 
