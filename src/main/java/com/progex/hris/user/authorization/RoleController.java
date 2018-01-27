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

import com.progex.hris.dto.RolePermissionDTO;

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
	 * Returns all the available role data. If there are no records returns an empty
	 * Set
	 * 
	 * @return {@link ResponseEntity<@link Set<@link Role>}
	 */
	@GetMapping("/roles")
	public ResponseEntity<Set<Role>> getAll() {
		Set<Role> roles = roleService.getAllRoles();
		if (roles.isEmpty())
			return new ResponseEntity<Set<Role>>(roles, HttpStatus.NOT_FOUND);
		return new ResponseEntity<Set<Role>>(roles, HttpStatus.OK);
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
	 * Adds permissions to the given role
	 * 
	 * @param {@link
	 * 			RolePermissionDTO}
	 */
	@PostMapping("roles/addPermissions")
	public void addPermissions(@RequestBody RolePermissionDTO rolePermissionDTO) {
		if (logger.isInfoEnabled())
			logger.info("Adding Permission to Role = " + rolePermissionDTO);
		Role role = roleService.getRole(rolePermissionDTO.getRoleId());
		if (role != null) {
			for (Short permId : rolePermissionDTO.getPermissionIds()) {
				Permission perm = permissionService.getPermissionById(permId);
				if (perm != null) {
					rolePermissionService.add(new RolePermission(role, perm));
				}
			}
		}
	}

	/**
	 * Removes permissions for the given role
	 * 
	 * @param {@link
	 * 			RolePermissionDTO}
	 */
	@DeleteMapping("roles/removePermissions")
	public void removePermissions(@RequestBody RolePermissionDTO rolePermissionDTO) {
		if (logger.isInfoEnabled())
			logger.info("Remove Permission from Role = " + rolePermissionDTO);
		Short roleId = rolePermissionDTO.getRoleId();
		Role role = roleService.getRole(roleId);
		if (role != null) {
			for (Short permId : rolePermissionDTO.getPermissionIds()) {
				Permission perm = permissionService.getPermissionById(permId);
				
				if (perm != null) {
					logger.info("Permission to be removed = " + perm);
					logger.info("Role to be removed = " + role);
					rolePermissionService.delete(roleId, permId);
				}
			}
		}
	}
}
