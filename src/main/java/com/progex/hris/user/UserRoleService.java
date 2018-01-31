package com.progex.hris.user;

public interface UserRoleService {

	public UserRole addUserRole(UserRole userRole);
	
	public void deleteUserRole(Short id);
	
	public UserRole updateUserRole(UserRole userRole);
}
