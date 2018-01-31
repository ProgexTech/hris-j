package com.progex.hris.dto;

import java.util.Set;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class RolePermissionDTO {

	@Id
	private Short roleId;
	
	@NotNull
	private Set<Short> permissionIds;

	public Short getRoleId() {
		return roleId;
	}

	public void setRoleId(Short roleId) {
		this.roleId = roleId;
	}

	public Set<Short> getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(Set<Short> permissionIds) {
		this.permissionIds = permissionIds;
	}

	@Override
	public String toString() {
		return "RolePermissionDTO [roleId=" + roleId + ", permissionIds=" + permissionIds + "]";
	}

}
