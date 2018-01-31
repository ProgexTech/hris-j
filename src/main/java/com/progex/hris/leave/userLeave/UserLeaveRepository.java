package com.progex.hris.leave.userLeave;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.progex.hris.user.User;

public interface UserLeaveRepository extends CrudRepository<UserLeave, Long> {

	public List<UserLeave> getUserLeaveByUserId(long userId);
	
	public List<UserLeave> getUserLeaveByUser(User user);
	
}
