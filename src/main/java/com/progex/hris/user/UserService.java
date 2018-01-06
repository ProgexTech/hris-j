package com.progex.hris.user;

import java.util.List;


public interface UserService {
	
	public List<User> getAllUsers();

	public User getUser(long id);

	public User addUser(User user);

	public void updateUser(long id, User user);

	public void deleteUser(long id);

	public User getUserByUserName(String uName);
	
	public List<User> getAllUsersBySupervisorId(long id);
}
