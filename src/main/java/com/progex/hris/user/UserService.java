package com.progex.hris.user;

import java.util.Set;


public interface UserService {
	
	public Set<User> getAllUsers();

	public User getUser(long id);

	public User addUser(User user);

	public void updateUser(long id, User user);

	public void deleteUser(long id);

	public User getUserByUserName(String uName);
	
	public Set<User> getAllUsersBySupervisorId(long id);

	public void patchUser(long id, User user);
}
