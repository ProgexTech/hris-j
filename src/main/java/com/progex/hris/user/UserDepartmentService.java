package com.progex.hris.user;


public interface UserDepartmentService {

	public UserDepartment addUserDepartment(UserDepartment userDepartment);

	public UserDepartment updateUserDepartment(UserDepartment userDepartment);
	
	public void removeUserDepartment(UserDepartmentId userDepartmentId);
	
	public void removeUserDepartmentForGivenUser(Long userId);
}
