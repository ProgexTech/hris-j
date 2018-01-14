package com.progex.hris.user.authorization;

import org.slf4j.LoggerFactory;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Permission related REST API functions are handled
 * 
 * @author indunil.moremada
 *
 */
@RestController
@RequestMapping("/api")
public class PermissionController {

	@Autowired
	private PermissionServiceImpl permissionService;

	private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);

	/**
	 * REST API function to get all permissions
	 * 
	 * @return
	 */
	@GetMapping("/permissions")
	public ResponseEntity<List<Permission>> getAllPermissions() {
		List<Permission> permissions = permissionService.getAllPermissions();
		if (permissions.isEmpty()) {
			return new ResponseEntity<List<Permission>>(HttpStatus.NO_CONTENT);
		}
		if (logger.isInfoEnabled())
			logger.info("Returning all the Permissions");

		return new ResponseEntity<List<Permission>>(permissions, HttpStatus.OK);
	}
	
	/**
	 * REST API function to add permissions
	 * 
	 * @param permission
	 *            {@link Permission}
	 * @return HTTP response {@link ResponseEntity}
	 */
	@PostMapping("/permissions")
	public ResponseEntity<Permission> addPermission(@RequestBody Permission permission) {
		if (logger.isInfoEnabled())
			logger.info("Permission to save " + permission);
		return new ResponseEntity<Permission>(permissionService.addPermission(permission), HttpStatus.OK);
	}

	/**
	 * Updates the permission with the given id
	 * 
	 * @param perm
	 * @param id
	 * @return HTTP response {@link ResponseEntity}
	 */
	@PutMapping("/permissions/{id}")
	public ResponseEntity<Permission> updatePermission(@RequestBody Permission perm, @PathVariable short id) {
		if (logger.isInfoEnabled())
			logger.info("Permission to update " + perm);
		Permission existtingPermission = permissionService.getPermissionById(id);
		if (existtingPermission == null) {
			logger.warn("Given Permission is not available in the database ");
		}
		perm.setId(id);
		return new ResponseEntity<Permission>(permissionService.updatePermission(perm), HttpStatus.OK);
	}

	/**
	 * Removes the permission with the given id from the database
	 * @param id
	 */
	@DeleteMapping("permissions/{id}")
	public void deletePermission(@PathVariable short id) {
		if (logger.isInfoEnabled())
			logger.info("Deleting the permission with the id = " + id);
		permissionService.deletePermission(id);
	}
}
