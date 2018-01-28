package com.progex.hris.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	private UserRoleRepository userRoleRepo;
	
	@Override
	public UserRole addUserRole(UserRole userRole) {
		return userRoleRepo.save(userRole);
	}

	@Override
	public void deleteUserRole(Short id) {
		userRoleRepo.delete(id);
	}

	@Override
	public UserRole updateUserRole(UserRole userRole) {
		return userRoleRepo.save(userRole);
	}

}
