package com.progex.hris.user;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.progex.hris.authorization.Role;
import com.progex.hris.authorization.RoleService;
import com.progex.hris.dto.UserDTO;
import com.progex.hris.dto.UserDepartmentDTO;
import com.progex.hris.organization.Department;
import com.progex.hris.organization.DepartmentService;
import com.progex.hris.organization.DesignationService;

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
	private UserService userService;

	@Autowired
	private UserDepartmentService userDeprtmentService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private DesignationService designationService;
	
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Returns
	 * <p>
	 * all the users in the database.
	 * </p>
	 * 
	 * @return {@link ResponseEntity}
	 */
	@GetMapping("/users")
	public ResponseEntity<Set<UserDTO>> geAlltUsers() {
		Set<User> users = userService.getAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<Set<UserDTO>>(HttpStatus.NO_CONTENT);
		}
		if (logger.isInfoEnabled())
			logger.info("Returning all the User´s");
		
		java.lang.reflect.Type targetListType = new TypeToken<Set<UserDTO>>() {}.getType();
		Set<UserDTO> UserDTOs = new HashSet<>();
		UserDTOs = modelMapper.map(users, targetListType);
		return new ResponseEntity<Set<UserDTO>>(UserDTOs, HttpStatus.OK);
	}

	/**
	 * Returns the user with the given id
	 * 
	 * @param id
	 * 
	 * 
	 * @return
	 *         <p>
	 *         Returns <tt>ResponseEntity<UserDTO> </tt> {@link ResponseEntity}
	 *         </p>
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable long id) {
		if (logger.isInfoEnabled())
			logger.info("User id to return " + id);

		User user = userService.getUser(id);
		if (user == null) {
			logger.warn("User with the id " + id + " not found in the database");
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}
		UserDTO uDto = modelMapper.map(user, UserDTO.class);
		return new ResponseEntity<UserDTO>(uDto, HttpStatus.OK);
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
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDto) {
		if (logger.isInfoEnabled())
			logger.info("User to save " + userDto);
		User user = modelMapper.map(userDto, User.class);
		User returnedUser = userService.addUser(user);
		UserDTO uDto = modelMapper.map(returnedUser, UserDTO.class);

		return new ResponseEntity<UserDTO>(uDto, HttpStatus.CREATED);
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
	public void updateUser(@RequestBody UserDTO userDto, @PathVariable long id) {
		if (logger.isInfoEnabled())
			logger.info("User to update " + userDto);
		User user = modelMapper.map(userDto, User.class);
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
	public void patchUser(@RequestBody UserDTO userDto, @PathVariable long id) {
		if (logger.isInfoEnabled())
			logger.info("User to partially update " + userDto);
		User user = modelMapper.map(userDto, User.class);
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
		
		userDeprtmentService.removeUserDepartmentForGivenUser(id);
		userService.deleteUser(id);
	}

	/**
	 * Returns all the users who are supervised by the given supervisor id
	 * 
	 * @param supervisorId
	 * @return List<User>
	 */
	@GetMapping("users/bySupervisor/{supervisorId}")
	public ResponseEntity<Set<UserDTO>> getAllUsersBySupervisor(@PathVariable long supervisorId) {
		
		Set<User> users = userService.getAllUsersBySupervisorId(supervisorId);
		java.lang.reflect.Type targetListType = new TypeToken<Set<UserDTO>>() {}.getType();
		Set<UserDTO> UserDTOs = new HashSet<>();
		UserDTOs = modelMapper.map(users, targetListType);
		
		return new ResponseEntity<Set<UserDTO>>(UserDTOs, HttpStatus.OK);
	}

	/**
	 * Assigning given role to the user
	 * 
	 * @param role
	 *            {@link Role}
	 * @param userId
	 *            user id which we wants to assign the given role
	 */
	@PostMapping("users/addRole/{userId}")
	public void addUserToRole(@RequestBody Role role, @PathVariable Long userId) {
		if (logger.isInfoEnabled())
			logger.info("Add User id = " + userId + " to Role = " + role);
		User user = userService.getUser(userId);
		Role originalRole = roleService.getRole(role.getId());
		if (originalRole != null && role != null) {
			userRoleService.addUserRole(new UserRole(user, originalRole));
		}
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
	 * @return UserDepartment {@link UserDepartmentDTO}
	 */

	@PostMapping("/users/addToDepartment")
	public ResponseEntity<UserDepartmentDTO> addUserToDepartment(@RequestBody UserDepartmentDTO userDepartmentDto) {
		if (logger.isInfoEnabled())
			logger.info("UserDepartment to save " + userDepartmentDto);
		
		User user = userService.getUser(userDepartmentDto.getUserId());
		if(user != null) {
			logger.warn("Invalid User id recieved");
		}
		Department department = departmentService.getDepartment(userDepartmentDto.getDepartmentId());
		if(department != null) {
			logger.warn("Invalid Department id recieved");
		}
		UserDepartment userDepartment = new UserDepartment(new UserDepartmentId(userDepartmentDto.getDepartmentId(), 
				userDepartmentDto.getUserId()), userDepartmentDto.getAssignedDate(), userDepartmentDto.getUnAssignedDate(), user, department);
		UserDepartment savedUD = userDeprtmentService.addUserDepartment(userDepartment);
		
		UserDepartmentDTO tobeReturnedDto = new UserDepartmentDTO();
		tobeReturnedDto.setAssignedDate(savedUD.getAssignedDate());
		tobeReturnedDto.setDepartmentId(savedUD.getDepartment().getId());
		tobeReturnedDto.setUnAssignedDate(savedUD.getUnAssignedDate());
		tobeReturnedDto.setUserId(savedUD.getUser().getId());
		
		return new ResponseEntity<UserDepartmentDTO>(tobeReturnedDto, HttpStatus.OK);
	}
}
