/**
 * 
 */
package com.siri.esmartHealthCare.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.dao.LoginDaoI;

/**
 * @author VENU
 *
 */
@Component
public class EsamrtAuthProvider implements AuthenticationProvider{

	@Autowired
	private LoginDaoI loginDao;
	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
			
		    /*User user = (User)auth.getPrincipal();
			String userName = user.getUsername();
			String password = user.getPassword();*/
		
		
		String userName = auth.getName();
		String password = auth.getCredentials().toString();
		System.out.println("user name is:\t"+userName);
		System.out.println("password is:\t"+password);
		
		String roleName = loginDao.getRoleNameByUserId(userName);
		System.out.println("role from data base is:\t"+roleName);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			GrantedAuthority authRole = new SimpleGrantedAuthority(roleName);
			
			
			
			authorities.add(authRole);
			
			/*User user = new User(userName, password, true,
					true, true, true, authorities);*/
			
			//ManageUserProfileBean mbean = new ManageUserProfileBean();
			
			
			

			return new UsernamePasswordAuthenticationToken(userName, password, authorities);
			
			
		//return null;
	}

	@Override
	public boolean supports(Class<? extends Object> authObject) {
        if(authObject.equals(UsernamePasswordAuthenticationToken.class)){
        	return true;
        }
		return false;
	}

	
}
