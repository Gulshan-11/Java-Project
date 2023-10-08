package com.oracle.secure.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
    private String role;
    private String userName;
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	public JwtResponse(String jwttoken, String role) {
		this.jwttoken = jwttoken;
		this.role = role;
	}

	public JwtResponse(String jwttoken, String role, String userName) {
		super();
		this.jwttoken = jwttoken;
		this.role = role;
		this.userName = userName;
	}
	public String getToken() {
		return this.jwttoken;
	}

	public String getRole() {
		return role;
	}
	public String getUserName() {
		return userName;
	}
	
}