package com.progex.hris.authorization;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * This contains all the {@link Role} related business logic
 * 
 * @author indunil.moremada
 *
 */
@Component
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Set<Role> getAllRoles() {
		Set<Role> roles = new HashSet<Role>();
		roleRepository.findAll().forEach(roles::add);
		return roles;
	}

	@Override
	public Role getRole(short id) {
		return roleRepository.findOne(id);
	}

	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role updateRole(short id, Role role) {
		return roleRepository.save(role);
		
	}

	@Override
	public void deleteRole(short id) {
		roleRepository.delete(id);
	}

	@Override
	public Role getRoleByType(String type) {
		return roleRepository.findByType(type);
	}
}
