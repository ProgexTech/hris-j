package com.progex.hris.user.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PermissionServiceImpl  implements PermissionService{

	@Autowired
	private PermissionRepository permissionRepository;
	
	@Override
	public Permission addPermission(Permission perm) {
		return permissionRepository.save(perm);
	}

	@Override
	public void deletePermission(short id) {
		permissionRepository.delete(id);
	}

	@Override
	public Permission updatePermission(Permission perm) {
		return permissionRepository.save(perm);
	}

	@Override
	public Permission getPermissionById(short id) {
		return permissionRepository.findOne(id);
	}

}
