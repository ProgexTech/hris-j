package com.progex.hris.user;
import org.springframework.data.repository.CrudRepository;

public interface UserDepartmentRepository extends CrudRepository<UserDepartment, UserDepartmentId>{
	
	public void deleteByUserDepartmentIdUserId(Long userId);
}
