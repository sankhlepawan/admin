package com.mm.admin.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class BioUserDetails implements org.springframework.security.core.userdetails.UserDetails{

	
	private static final long serialVersionUID = 1L;
	
	private  Collection<? extends GrantedAuthority> roles;
	private String password;
	private String username;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	private String sessionId;
	
	
	public UserDetails sessionId(String sessionId) {
		this.sessionId = sessionId;
		return this;
	}
	
	public UserDetails rolse( Collection<? extends GrantedAuthority> roles) {
		this.roles = roles;
		return this;
	}
	
	public UserDetails password(String pwd) {
		this.password = pwd;
		return this;
	}
	
	public UserDetails username(String username){
		this.username = username;
		return this;
	}
	
	public UserDetails accountNonExpired(boolean ac) {
		this.accountNonExpired = ac;
		return this;
		
	}
	
	public UserDetails accountNonLocked(boolean locked) {
		this.accountNonLocked = locked;
		return this;
	}
	
	public UserDetails credentialsNonExpired(boolean expired) {
		this.credentialsNonExpired = expired;
		return this;
	}
	
	public UserDetails enabled(boolean enabled) {
		this.enabled = enabled;
		return this;
		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public String getSessionId() {
		return sessionId;
	}
	
	

}
