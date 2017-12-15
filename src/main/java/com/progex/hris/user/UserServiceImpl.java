package com.progex.hris.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.progex.hris.user.authorization.Role;
import com.progex.hris.user.authorization.RoleRepository;

/**
 * UserServiceImpl User related core functionalities will be handled in this class
 * 
 * @author indunil.moremada
 */
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(long id) {
		return userRepository.findOne(id);
	}

	public User addUser(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userRepository.save(user);
	}

	public void updateUser(long id, User user) {
		if (user.getPassword() != null)
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userRepository.save(user);
	}

	public void deleteUser(long id) {
		userRepository.delete(id);
	}

	public User getUserByUserName(String uName) {
		return userRepository.findByUserName(uName);
	}

	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}

	public Role getRole(short id) {
		return roleRepository.findOne(id);
	}

	public void deleteRole(short id) {
		roleRepository.delete(id);
	}

//	public Role getRoleByType(Role.Type type) {
//		return roleRepository.findByType(type);
//
//	}

	public void patchUser(long id, User user) {
		User oldUser = userRepository.findOne(id);
		if (user.getAddress() != null) {
			oldUser.setAddress(user.getAddress());
		}
		if (user.getContacts() != null) {
			oldUser.setContacts(user.getContacts());
		}
		if (user.getDesignation() != null) {
			oldUser.setDesignation(user.getDesignation());
		}
		if (user.getEmail() != null) {
			oldUser.setEmail(user.getEmail());
		}
		if (user.getDob() != null) {
			oldUser.setDob(user.getDob());
		}
		if (user.getFirstName() != null) {
			oldUser.setFirstName(user.getFirstName());
		}
		if (user.getLastName() != null) {
			oldUser.setLastName(user.getLastName());
		}
		if (user.getRole() != null) {
			oldUser.setRole(user.getRole());
		}
		if (user.getNic() != null) {
			oldUser.setNic(user.getNic());
		}
		if (user.getPassword() != null) {
			oldUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		}
		if (user.getUserName() != null) {
			oldUser.setUserName(user.getUserName());
		}
		if (user.getActive() != null) {
			oldUser.setActive(user.getActive());
		}
		userRepository.save(oldUser);
	}
}
