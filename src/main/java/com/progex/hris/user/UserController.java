package com.progex.hris.user;

import java.lang.invoke.MethodType;
import java.util.List;
import java.util.Map;

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

/**
 * UserController Rest Controller to manipulate user related stuff
 * 
 * @author indunil.moremada
 */
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	/**
	 * Returns all the users in the database.
	 * 
	 * @return {@link ResponseEntity}
	 */
	@RequestMapping("/users")
	public ResponseEntity<List<User>> geAlltUsers() {
		List<User> users = userService.getAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	/**
	 * Returns the user with the given id
	 * 
	 * @param id
	 *            should be a long
	 * 
	 * @return {@link ResponseEntity}
	 */
	@RequestMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) {
		User user = userService.getUser(id);
		if (user == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(user, HttpStatus.OK);
	}

	/**
	 * Inserts the given user to the database. All the mandatory fields must be
	 * included to the user object
	 * 
	 * @param user
	 *            {@link User}
	 * @return {@link ResponseEntity}
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		Role existingRole = userService.getRole(user.getRole().getId());
		if (existingRole == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		userService.addUser(user);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	/**
	 * Updates the user with the given id. Whole user object will be updated
	 * 
	 * @param user
	 *            {@link User}
	 * @param id
	 *            user id
	 * @return {@link ResponseEntity}
	 * 
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable long id) {
		user.setId(id);
		userService.updateUser(id, user);
	}

	/**
	 * Partially updates the user object. Only the provided fields will be updated
	 * 
	 * @param user
	 *            {@link User}
	 * @param id
	 *            user id
	 * @return {@link ResponseEntity}
	 * 
	 */
	@RequestMapping(method = RequestMethod.PATCH, value = "/users/{id}")
	public void patchUser(@RequestBody User user, @PathVariable long id) {
		userService.patchUser(id, user);
	}

	/**
	 * Deletes the user with the given id from the database
	 * 
	 * @param id
	 *            user id
	 * @return {@link ResponseEntity}
	 * 
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "users/{id}")
	public void deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
	}

	/**
	 * Inserts new Role to the database
	 * 
	 * @param role
	 *            {@link Role}
	 * 
	 * @return {@link ResponseEntity}
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/roles")
	public ResponseEntity<User> addRole(@RequestBody Role role) {
		Role roleWithType = userService.getRoleByType(role.getType());
		if (roleWithType != null) {
			return new ResponseEntity(roleWithType, HttpStatus.CONFLICT);
		}
		Role savedRole = userService.addRole(role);
		if (savedRole == null) {
			return new ResponseEntity(HttpStatus.METHOD_FAILURE);
		}
		return new ResponseEntity(savedRole, HttpStatus.OK);
	}

	/**
	 * Deletes Role with the given id from the database
	 * 
	 * @param id
	 * 
	 * @return {@link ResponseEntity}
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/roles/{id}")
	public void deleteRole(@PathVariable short id) {
		userService.deleteRole(id);
	}
}
