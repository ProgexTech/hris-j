package com.progex.hris.leave.userLeave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserLeaveController {
	
	@Autowired
	private UserLeaveService userLeaveService;

	@RequestMapping("/userLeaves")
	public List<UserLeave> getAllUserLeaves() {
		return userLeaveService.getAllUserLeaves();
	}
	
	@RequestMapping("/userLeaves/{id}")
	public UserLeave getUserLeave(@PathVariable long id) {
		return userLeaveService.getUserLeaveById(id);
	}
	
	@RequestMapping("/userLeaves/{userId}")
	public List<UserLeave> getAllUserLeavesByUserId(@PathVariable long userId) {
		return userLeaveService.getAllUserLeavesByUserId(userId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/userLeaves")
	public void addUserLeave(@RequestBody UserLeave userLeave) {
		userLeaveService.addUserLeave(userLeave);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/userLeaves/{id}")
	public void updateUserLeave(@RequestBody UserLeave userLeave, @PathVariable long id) {
		userLeaveService.updateUserLeave(id, userLeave);
	}
	
}
