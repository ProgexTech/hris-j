package com.progex.hris.authorization;

public interface RolePermissionService {

	public RolePermission add(RolePermission rolePermission);

	public void delete(Integer id);

	public void delete(Short roleId, Short permId);
}
