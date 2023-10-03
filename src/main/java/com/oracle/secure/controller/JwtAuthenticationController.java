package com.oracle.secure.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

//import com.oracle.secure.config.JwtTokenUtil;
//import com.oracle.secure.model.JwtRequest;
//import com.oracle.secure.model.JwtResponse;
import com.oracle.secure.model.UserDto;
import com.oracle.secure.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	//@Autowired
	//private AuthenticationManager authenticationManager;

	//@Autowired
	//private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//		
//		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//		System.out.println("Loaded .. ");
//		final String token = jwtTokenUtil.generateToken(userDetails);
//		System.out.println("Toekn generated .. ");
//
//		 String roles=userDetailsService.getRoles();
//		 String userName=userDetailsService.getUserName();
//		return ResponseEntity.ok(new JwtResponse(token,roles,userName));
//	}
//
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
//		return ResponseEntity.ok(userDetailsService.save(user));
//	}
//
//	private void authenticate(String username, String password) throws Exception {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);
//		}
//	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
	
	
}
