package com.progex.hris.authorization;

import java.util.Set;

public interface PermissionService {
	
	public List<Permission> getAllPermissions();

	public Permission addPermission(Permission perm);
	
	public void deletePermission(short id);
	
	public Permission updatePermission(Permission perm);
	
	public Permission getPermissionById(short id);
	
	public Set<Permission> getAllPermissions();
}
