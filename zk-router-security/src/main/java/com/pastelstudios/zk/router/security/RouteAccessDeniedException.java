package com.pastelstudios.zk.router.security;

import com.pastelstudios.zk.router.RouterException;

public class RouteAccessDeniedException extends RouterException {

	private static final long serialVersionUID = 3470519149664642168L;
	private static final String ACCESS_DENIED_CODE = "com.pastelstudios.zk.router.AccessDenied";

	public RouteAccessDeniedException() {
		super(ACCESS_DENIED_CODE);
	}

}
