package com.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.service.ManagerService;

@RestController

public class ManagerController {

	@Autowired
	private ManagerService managerService;
	@RequestMapping(value="/approve/{userName}",method=RequestMethod.GET)
	public boolean approveLoan(@PathVariable String userName,@RequestBody String applyId ) {
		managerService.approveLoan(userName, applyId);
		return true;
	}
	
}
