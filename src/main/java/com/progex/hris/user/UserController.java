package com.progex.hris.user;

import java.lang.invoke.MethodType;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
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
		if(logger.isInfoEnabled())
			logger.info("Returning all the User´s");
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	/**
	 * Returns the user with the given id
	 * 
	 * @param id
	 * 
	 * 
	 * @return {@link ResponseEntity}
	 */
	@RequestMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) {
		if(logger.isInfoEnabled())
			logger.info("User id to return "+id);
		
		User user = userService.getUser(id);
		if (user == null) {
			logger.warn("User with the id "+id+" not found in the database");
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
	public ResponseEntity<User> addUser(@RequestBody User user) {
		if(logger.isInfoEnabled())
			logger.info("User to save " + user);
		
		Role existingRole = userService.getRole(user.getRole().getId());
		if (existingRole == null) {
			logger.warn("Invalid Role cannot proceed to save user id "+ user.getId());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}

	/**
	 * Updates the user with the given id. Whole user object will be updated
	 * 
	 * @param JSON String of a User        
	 * @param id
	 *            
	 * @return {@link ResponseEntity}
	 * 
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable long id) {
		if(logger.isInfoEnabled())
			logger.info("User to update " + user);
		
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
		if(logger.isInfoEnabled())
			logger.info("User to partially update " + user);
		
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
		if(logger.isInfoEnabled())
			logger.info("Removing user id = " + id);
		
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
		if(logger.isInfoEnabled())
			logger.info("Role to save " + role);
		
		Role roleWithType = userService.getRoleByType(role.getType());
		if (roleWithType != null) {
			logger.error("Given role is already existed in the database");
			return new ResponseEntity(roleWithType, HttpStatus.CONFLICT);
		}
		Role savedRole = userService.addRole(role);
		if (savedRole == null) {
			logger.error("Role cannot be saved. Something went wrong while saving");
			return new ResponseEntity(HttpStatus.METHOD_FAILURE);
		}
		if(logger.isInfoEnabled())
			logger.info("Role has been successfully saved " + role);
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
		if(logger.isInfoEnabled())
			logger.info("To be removed Role id = " + id);
		
		userService.deleteRole(id);
	}
}
