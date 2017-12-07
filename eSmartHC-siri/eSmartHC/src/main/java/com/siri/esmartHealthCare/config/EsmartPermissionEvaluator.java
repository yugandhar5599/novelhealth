/**
 * 
 */
package com.siri.esmartHealthCare.config;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @author VENU
 *
 */
@Component
public class EsmartPermissionEvaluator implements PermissionEvaluator {

	@Override
	public boolean hasPermission(Authentication auth, 
			Object module, Object permission) {
		// TODO Auto-generated method stub
		
		String userName = auth.getName();
		System.out.println("user Name is:\t"+userName);
		String mod = module.toString();
		System.out.println("module is:\t"+mod);
		String per = permission.toString();
		
	
		
		System.out.println("permission is:\t"+per);
		if(userName != null && !userName.isEmpty()){
			if(mod != null && !mod.isEmpty()){
				if(per != null && !per.isEmpty()){
					//write actual database check
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean hasPermission(Authentication arg0, 
			Serializable arg1,
			String arg2, Object arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
