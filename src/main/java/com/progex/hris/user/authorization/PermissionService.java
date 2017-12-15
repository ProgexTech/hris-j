package com.progex.hris.user.authorization;


public interface PermissionService {

	public Permission addPermission(Permission perm);
	
	public void deletePermission(short id);
	
	public Permission updatePermission(Permission perm);
	
	public Permission getPermissionById(short id);
}
