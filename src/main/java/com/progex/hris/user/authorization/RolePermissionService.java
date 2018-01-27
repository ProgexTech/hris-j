package com.progex.hris.user.authorization;

import org.springframework.stereotype.Component;

public interface RolePermissionService {

	public RolePermission add(RolePermission rolePermission);

	public void delete(Integer id);

	public void delete(Short roleId, Short permId);
}
