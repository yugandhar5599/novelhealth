package com.dotridge.config;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

	public boolean hasPermission(Authentication arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasPermission(Authentication arg0, Serializable arg1, String arg2, Object arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
