package com.progex.hris.user.authorization;

import java.util.List;

public interface RoleService {
	
	public List<Role> getAllRoles();

	public Role getRole(short id);

	public Role addRole(Role role);

	public Role updateRole(short id, Role role);

	public void deleteRole(short id);

	public Role getRoleByType(String type);
}
