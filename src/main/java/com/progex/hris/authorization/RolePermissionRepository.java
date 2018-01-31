package com.progex.hris.authorization;

import org.springframework.data.repository.CrudRepository;

public interface RolePermissionRepository extends CrudRepository<RolePermission, Integer>{

	void deleteByRoleIdAndPermissionId(Short roleId, Short PermissionId);
}
