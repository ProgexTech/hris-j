package com.progex.hris.user;

import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progex.hris.organization.Department;
import com.progex.hris.organization.DepartmentServiceImpl;
import com.progex.hris.user.authorization.Role;

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

	@Autowired
	private UserDepartmentServiceImpl userDeprtmentService;

	@Autowired
	private DepartmentServiceImpl departmentService;

	/**
	 * Returns
	 * <p>
	 * all the users in the database.
	 * </p>
	 * 
	 * @return {@link ResponseEntity}
	 */
	@GetMapping("/users")
	public ResponseEntity<List<User>> geAlltUsers() {
		List<User> users = userService.getAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		if (logger.isInfoEnabled())
			logger.info("Returning all the User´s");

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	/**
	 * Returns the user with the given id
	 * 
	 * @param id
	 * 
	 * 
	 * @return
	 *         <p>
	 *         Returns <tt>ResponseEntity<User> </tt> {@link ResponseEntity}
	 *         </p>
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) {
		if (logger.isInfoEnabled())
			logger.info("User id to return " + id);

		User user = userService.getUser(id);
		if (user == null) {
			logger.warn("User with the id " + id + " not found in the database");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	/**
	 * <p>
	 * Inserts the given user to the database. All the mandatory fields must be
	 * included to the user object
	 * </p>
	 * 
	 * @param User
	 *            {@link User}
	 * 
	 * @return {@link ResponseEntity}
	 * 
	 */
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		if (logger.isInfoEnabled())
			logger.info("User to save " + user);

		Role existingRole = userService.getRole(user.getRole().getId());
		if (existingRole == null) {
			logger.warn("Invalid Role cannot proceed to save user id " + user.getId());
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}

	/**
	 * Updates the user with the given id. Whole user object will be updated
	 * 
	 * @param JSON
	 *            String of a User
	 * @param id
	 * 
	 * @return {@link ResponseEntity}
	 * 
	 */
	@PutMapping("/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable long id) {
		if (logger.isInfoEnabled())
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
	@PatchMapping("/users/{id}")
	public void patchUser(@RequestBody User user, @PathVariable long id) {
		if (logger.isInfoEnabled())
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
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable long id) {
		if (logger.isInfoEnabled())
			logger.info("Removing user id = " + id);

		userService.deleteUser(id);
	}

	/**
	 * Returns all the users who are supervised by the given supervisor id
	 * 
	 * @param supervisorId
	 * @return List<User>
	 */
	@GetMapping("users/bySupervisor/{supervisorId}")
	public ResponseEntity<List<User>> getAllUsersBySupervisor(@PathVariable long supervisorId) {

		return new ResponseEntity<List<User>>(userService.getAllUsersBySupervisorId(supervisorId), HttpStatus.OK);
	}

	/**
	 * Adds users to the given department
	 * 
	 * @param {@link
	 * 			User}
	 * @param {@link
	 * 			Department}
	 * @param joinedDate
	 *            date
	 * @return UserDepartment {@link UserDepartment}
	 */

	@PostMapping("/userDepartments")
	public ResponseEntity<UserDepartment> addUserToDepartment(@RequestBody UserDepartment userDepartment) {
		if (logger.isInfoEnabled())
			logger.info("UserDepartment to save " + userDepartment);
		if (userDepartment.getUserDepartmentId() != null
				&& userDepartment.getUserDepartmentId().getDepartmentId() != null) {
			short departmentId = userDepartment.getUserDepartmentId().getDepartmentId();
			Department department = departmentService.getDepartment(departmentId);
			if (department != null) {
				User user = userService.getUser(userDepartment.getUserDepartmentId().getUserId());
				if (user != null) {
					return new ResponseEntity<UserDepartment>(userDeprtmentService.addUserDepartment(userDepartment),
							HttpStatus.CREATED);
				} else {
					logger.warn("No User found for id = " + userDepartment.getUserDepartmentId().getUserId());
				}
			} else {
				logger.warn("No Department found for id = " + departmentId);
			}
		} else {
			logger.warn("Invalid Department id received");
			return new ResponseEntity<UserDepartment>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserDepartment>(HttpStatus.BAD_REQUEST);
	}
}
