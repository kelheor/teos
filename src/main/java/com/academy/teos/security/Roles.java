package com.academy.teos.security;

public enum Roles {
	ROLE_SUPERUSER(
			"ROLE_SUPERUSER"), ROLE_USER("ROLE_USER");

	private String role;

	Roles(String role) {
		this.role = role;
	}

	public String getValue() {
		return role;
	}
}