package com.progex.hris.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class UserDepartmentServiceImpl implements UserDepartmentService {

	@Autowired
	private UserDepartmentRepository userDepartmentRepo;

	@Override
	public UserDepartment addUserDepartment(UserDepartment userDepartment) {
		return userDepartmentRepo.save(userDepartment);
	}

	@Override
	public UserDepartment updateUserDepartment(UserDepartment userDepartment) {
		return userDepartmentRepo.save(userDepartment);
	}

	@Override
	public void removeUserDepartment(UserDepartmentId userDepartmentId) {
		userDepartmentRepo.delete(userDepartmentId);
	}

	@Override
	public void removeUserDepartmentForGivenUser(Long userId) {
		userDepartmentRepo.deleteByUserDepartmentIdUserId(userId);
	}

}
