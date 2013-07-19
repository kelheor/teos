package com.academy.teos.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class UserAuthentication implements Authentication {

	private static final long serialVersionUID = -3091441742758356129L;

	private boolean authenticated;

	private final UserSession userSession;

	private final UserAuthenticationDetails userAuthenticationDetails;

	public UserAuthentication(UserSession userSession, UserAuthenticationDetails authenticationDetails) {
		super();
		this.userSession = userSession;
		this.userAuthenticationDetails = authenticationDetails;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return (userSession != null) ? userSession.getAuthorities() : null;
	}

	@Override
	public Object getCredentials() {
		return (userSession != null) ? userSession.getPassword() : null;
	}

	@Override
	public Object getDetails() {
		return userAuthenticationDetails;
	}

	@Override
	public Object getPrincipal() {
		return (userSession != null) ? userSession.getUsername() : null;
	}

	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
		this.authenticated = authenticated;
	}

	@Override
	public String getName() {
		return (userSession != null) ? userSession.getUsername() : null;
	}

	public UserSession getUserSession() {
		return userSession;
	}
}
