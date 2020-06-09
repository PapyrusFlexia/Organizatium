package com.proyecto.services.impl;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proyecto.dao.UserDao;
import com.proyecto.model.UserProfile;

@Service("userService")
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	/*
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Strength set as 12
String encodedPassword = encoder.encode("UserPassword");
	*/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.proyecto.model.User u = userDao.findByEmail(username);

		List<GrantedAuthority> authorities = buildUserAuthority();

		return buildUserForAuthentication(u, authorities);
	}

	// Converts com.proyecto.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.proyecto.model.User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

	private List<GrantedAuthority> buildUserAuthority() {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
	/**	for (UserProfile userRole : userRoles	) {
			setAuths.add(new SimpleGrantedAuthority("UER"));
		} */

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
}
