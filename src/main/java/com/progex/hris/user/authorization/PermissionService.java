package com.progex.hris.user.authorization;

import java.util.List;

public interface PermissionService {
	
	public List<Permission> getAllPermissions();

	public Permission addPermission(Permission perm);
	
	public void deletePermission(short id);
	
	public Permission updatePermission(Permission perm);
	
	public Permission getPermissionById(short id);
}
