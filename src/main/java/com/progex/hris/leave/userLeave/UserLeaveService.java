package com.progex.hris.leave.userLeave;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progex.hris.user.User;

@Service
public class UserLeaveService {

	@Autowired
	private UserLeaveRepository userLeaveRepository;
	
	public List<UserLeave> getAllUserLeaves() {
		List<UserLeave> userLeaveList = new ArrayList<>();
		userLeaveRepository.findAll().forEach(userLeaveList::add);
		return userLeaveList;
	}
	
	public List<UserLeave> getAllUserLeavesByUserId(long userId) {
		return userLeaveRepository.getUserLeaveByUserId(userId);
	}
	
	public List<UserLeave> getAllUserLeavesByUser(User user) {
		return userLeaveRepository.getUserLeaveByUser(user);
	}
	
	public UserLeave getUserLeaveById(long id) {
		return userLeaveRepository.findOne(id);
	}
	
}
