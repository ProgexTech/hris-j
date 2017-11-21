package com.progex.hris.user;

import java.lang.invoke.MethodType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.progex.hris.user.*;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("/users")
	public ResponseEntity<List<User>> geAlltUsers() {
		List<User> users = userService.getAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) {
		User user = userService.getUser(id);
		if (user == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(user, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		Role existingRole = userService.getRole(user.getRole().getId());
		if(existingRole == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		userService.addUser(user);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable long id) {
		userService.updateUser(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "users/{id}")
	public void deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
	}

	@RequestMapping(method = RequestMethod.POST, value="/roles")
	public ResponseEntity<User> addRole(@RequestBody Role role) {
		Role roleWithType = userService.getRoleByType(role.getType());
		if(roleWithType != null) {
			return new ResponseEntity(roleWithType, HttpStatus.CONFLICT);
		}
		Role savedRole = userService.addRole(role);
		if(savedRole == null) {
			return new ResponseEntity(HttpStatus.METHOD_FAILURE);
		}
		return new ResponseEntity(savedRole, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/roles/{id}")
	public void deleteRole(@PathVariable short id) {
		userService.deleteRole(id);
	}
}
