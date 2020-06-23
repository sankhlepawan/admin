package com.mm.admin.service.v1.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mm.admin.service.v1.IUserService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	IUserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			com.mm.admin.model.v1.User user = userService.getUserByUsername(username);
			final Collection<? extends GrantedAuthority> authorities =
					user.getRoles().stream()
							.map(r -> r.getRoleName().toString())
	                        .map(SimpleGrantedAuthority::new)
	                        .collect(Collectors.toList());
			
			return new User(user.getUsername(), user.getPassword(),authorities);
		}catch(Exception e) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
//		if ("javainuse".equals(username)) {
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
	}
}
