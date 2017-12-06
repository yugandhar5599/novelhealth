package com.dotridge.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.dotridge.domain.Permission;
import com.dotridge.domain.Role;
import com.dotridge.domain.UserProfile;
import com.dotridge.util.CustomPasswordEncoder;

@Component
public class CutomAuthenticationProvider implements AuthenticationProvider
{
	@Autowired
	private SessionFactory sessionFactory; 
	
	/*@Autowired
	private PasswordEncoder passwordEncoder;*/
	
	/*\
	 * 
	 * \
	private static  String QUARY = "SELECT up.userId,up.password,r.roleName,p.name FROM UserProfile up, "
			+ "Role r, Permission p where p.permissionId = r.permissionId and r.roleId = up.roleId and up.userId=";*/
	

	private static  String QUARY = "SELECT up.userId,up.password,r.roleName FROM UserProfile up, "
			+ "Role r where r.roleId = up.role_roleId and up.userId=";
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException 
	{
		String userName = authentication.getName();
		String password = (String) authentication.getCredentials();
		System.out.println("UserName : " + userName + " Password : " + password);
		
		password = CustomPasswordEncoder.encodePassword(password);
		
		QUARY = QUARY+"\'"+userName+"\'"+" and up.password="+"\'"+password+"\'";

		System.out.println("query is:\t"+QUARY);
		Session session = sessionFactory.openSession();
		SQLQuery sqlQuery = session.createSQLQuery(QUARY);
		List<Object[]> list = sqlQuery.list();
		Object[] array = list.get(0);
		String role = (String) array[2];
		//String permission = (String)array[3];
		 GrantedAuthority roleauth = new SimpleGrantedAuthority(role);
		// GrantedAuthority permauth = new SimpleGrantedAuthority(permission);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(roleauth);
		//authorities.add(permauth);
		return new UsernamePasswordAuthenticationToken(userName, password, authorities);
	}

	public boolean supports(Class<?> authentication) 
	{
		return true;
	}

}
