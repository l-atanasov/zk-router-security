package com.pastelstudios.zk.router.security.spring;

import java.util.List;

import com.pastelstudios.zk.router.security.SecurityPlugin;

public class SecurityPluginFactoryBean extends SecurityPlugin {

	public void setSecurityConstraints(List<String> constraints) {
		for(String constraintDefinition : constraints) {
			String[] parts = constraintDefinition.split("=>");
			if(parts.length != 2) {
				throw new IllegalArgumentException("Cannot parse constraint " + constraintDefinition + ". Security constraints must be defined as 'path => roles'!");
			}
			String path = parts[0].trim().toLowerCase();
			String roles = parts[1].trim().toUpperCase();
			addSecurityConstraint(path, roles);
		}
	}
}
