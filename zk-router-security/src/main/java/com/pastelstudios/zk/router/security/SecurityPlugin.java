package com.pastelstudios.zk.router.security;

import java.util.LinkedList;
import java.util.List;

import org.zkoss.zk.ui.Component;

import com.pastelstudios.zk.router.RouterException;
import com.pastelstudios.zk.router.RouterUtil;
import com.pastelstudios.zk.router.ZkRouter;
import com.pastelstudios.zk.router.plugin.EmptyPlugin;

public class SecurityPlugin extends EmptyPlugin {

	private List<ZkRouteSecurityConstraint> securityConstraints = new LinkedList<>();
	
	@Override
	public void beforeRouting(ZkRouter router, Component content, String url) throws RouterException {
		ZkRouteSecurityConstraint securityConstraint = findSecurityConstraint(url);
		if(securityConstraint != null && !securityConstraint.hasAccess()) {
			throw new RouteAccessDeniedException();
		}
	}
	
	private ZkRouteSecurityConstraint findSecurityConstraint(String url) {
		for(ZkRouteSecurityConstraint securityConstraint : securityConstraints) {
			if(securityConstraint.matches(url)) {
				return securityConstraint;
			}
		}
		return null;
	}
	
	public void addSecurityConstraint(String path, String roles) {
		path = RouterUtil.removeFirstAndLastSlash(path);
		securityConstraints.add(new ZkRouteSecurityConstraint(path, roles));
	}
}
