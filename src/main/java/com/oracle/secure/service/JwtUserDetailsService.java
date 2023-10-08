package com.oracle.secure.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oracle.secure.model.User;
import com.oracle.secure.model.UserDto;
import com.oracle.secure.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userDao;
	private String roles;
	private String userName;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	public UserDetails loadUserByUsername(String username)  throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
		System.out.println("Roles : "+roles);
		setRoles(roles.toString());
		setUserName(user.getUsername());
		System.out.println("****");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				roles);
		//return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
			//	new ArrayList<>());
	}
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}


	public User save(UserDto user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		return userDao.save(newUser);
	}
}