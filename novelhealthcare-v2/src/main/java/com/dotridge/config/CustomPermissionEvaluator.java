package com.dotridge.config;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

	public boolean hasPermission(Authentication authentication, Object module, Object permission) {
		Collection<? extends GrantedAuthority> authList = authentication.getAuthorities();
		if(authList != null && !authList.isEmpty()){
			/*for(GrantedAuthority auth : authList){
				if(auth.getAuthority().equals(module.toString())){
					
				}
			}*/
			if(authList.contains(module.toString()) && authList.contains(permission.toString())){
				return true;
			}
		}
		
		
		return false;
	}

	public boolean hasPermission(Authentication arg0, Serializable arg1, String arg2, Object arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
