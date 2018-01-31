package com.progex.hris.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolePermissionServiceImpl implements RolePermissionService {

	@Autowired
	RolePermissionRepository rolePermissionRepository;

	public RolePermission add(RolePermission rolePermission) {
		return rolePermissionRepository.save(rolePermission);
	}

	public void delete(Integer id) {
		rolePermissionRepository.delete(id);
	}

	@Override
	public void delete(Short roleId, Short permId) {
		rolePermissionRepository.deleteByRoleIdAndPermissionId(roleId, permId);
	}
}
