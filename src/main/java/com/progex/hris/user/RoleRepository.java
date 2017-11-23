package com.progex.hris.user;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Short>{

	public Role findByType(Role.Type type);
} 
