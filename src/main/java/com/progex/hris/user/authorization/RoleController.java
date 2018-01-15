package com.progex.hris.user.authorization;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller which handles all the permission related functionalities
 * related to each and every {@link Role} instance
 * 
 * @author indunil.moremada
 */
@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	RoleService roleService;

	@Autowired
	RolePermissionService rolePermissionService;

	@Autowired
	PermissionService permissionService;

	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

	/**
	 * Inserts new Role to the database
	 * 
	 * @param <p>
	 *            role {@link Role}
	 *            </p>
	 * 
	 * @return {@link ResponseEntity}
	 */
	@PostMapping("/roles")
	public ResponseEntity<Role> addRole(@RequestBody Role role) {
		if (logger.isInfoEnabled())
			logger.info("Role to save " + role);

		Role roleWithType = roleService.getRoleByType(role.getType());
		if (roleWithType != null) {
			logger.error("Given role is already existed in the database");
			return new ResponseEntity<Role>(roleWithType, HttpStatus.CONFLICT);
		}
		Role savedRole = roleService.addRole(role);
		if (savedRole == null) {
			logger.error("Role cannot be saved. Something went wrong while saving");
			return new ResponseEntity<Role>(HttpStatus.BAD_REQUEST);
		}
		if (logger.isInfoEnabled())
			logger.info("Role has been successfully saved " + role);
		return new ResponseEntity<Role>(savedRole, HttpStatus.OK);
	}

	/**
	 * Deletes Role with the given id from the database
	 * 
	 * @param id
	 * 
	 * @return {@link ResponseEntity}
	 */
	@DeleteMapping("/roles/{id}")
	public void deleteRole(@PathVariable short id) {
		if (logger.isInfoEnabled())
			logger.info("To be removed Role id = " + id);

		roleService.deleteRole(id);
	}

	/**
	 * Returns Role with the given id
	 * 
	 * @param id
	 */
	@GetMapping("/roles/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable short id) {
		if (logger.isInfoEnabled())
			logger.info("Retrieving Role id = " + id);
		return new ResponseEntity<Role>(roleService.getRole(id), HttpStatus.OK);
	}

	/**
	 * Adds permission to a given role
	 * 
	 * @param permissions
	 *            Set<{@link Permission}>
	 * @param id
	 *            Role id
	 */
	@PostMapping("roles/addPermission/{id}")
	public void addPermissionToRole(@RequestBody Set<Permission> permissions, @PathVariable Short id) {
		if (logger.isInfoEnabled())
			logger.info("Adding Permission = " + permissions + " to Role id = " + id);
		Role role = roleService.getRole(id);
		if (role != null) {
			for (Permission permission : permissions)
				rolePermissionService.add(new RolePermission(role, permission));
		}
	}

	// @DeleteMapping("roles/removePermission/{roleId}/{permId}")
	// public void removePermissionFromRole(@PathVariable Short roleId,
	// @PathVariable Short permId) {
	// if(logger.isInfoEnabled())
	// logger.info("Removing Permission ids = " + permId+" from Role id = "+roleId);
	//
	// rolePermissionService.delete(roleId, permId);
	// }
}
