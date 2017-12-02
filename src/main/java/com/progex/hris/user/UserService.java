package com.progex.hris.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

public interface UserService {
	
	public List<User> getAllUsers();

	public User getUser(long id);

	public User addUser(User user);

	public void updateUser(long id, User user);

	public void deleteUser(long id);

	public User getUserByUserName(String uName);
}
