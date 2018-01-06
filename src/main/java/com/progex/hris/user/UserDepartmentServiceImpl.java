package com.progex.hris.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDepartmentServiceImpl implements UserDepartmentService {

	@Autowired
	private UserDepartmentRepository userDepartmentRepo;

	@Override
	public UserDepartment addUserDepartment(UserDepartment userDepartment) {
		return userDepartmentRepo.save(userDepartment);
	}
}
