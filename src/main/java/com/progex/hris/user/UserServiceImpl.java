package com.progex.hris.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.progex.hris.user.*;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(long id) {
		return userRepository.findOne(id);
	}

	public void addUser(User user) {
		user.setpWord(new BCryptPasswordEncoder().encode(user.getpWord()));
		userRepository.save(user);
	}

	public void updateUser(long id, User user) {
		userRepository.save(user);
	}

	public void deleteUser(long id) {
		userRepository.delete(id);
	}

	public User getUserByUserName(String uName) {
		return userRepository.findByUserName(uName);
	}
}
