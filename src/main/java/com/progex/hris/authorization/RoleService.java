package com.progex.hris.authorization;

import java.util.Set;

public interface RoleService {
	
	public Set<Role> getAllRoles();

	public Role getRole(short id);

	public Role addRole(Role role);

	public Role updateRole(short id, Role role);

	public void deleteRole(short id);

	public Role getRoleByType(String type);
}
