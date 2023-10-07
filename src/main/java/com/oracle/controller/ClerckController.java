package com.oracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.entity.ActiveLoans;
import com.oracle.entity.Application;
import com.oracle.entity.ClerkCustomer;
import com.oracle.entity.Customer;
import com.oracle.service.ClerkService;
import com.oracle.service.CustomerService;
@RestController
@CrossOrigin
public class ClerckController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private ClerkService clerkService;
	@RequestMapping(value="/AddNewCustomer" ,  method=RequestMethod.POST)
	public String addNewCustomer(@RequestBody ClerkCustomer ccData ) {
		customerService.addNewCustomerDetails(ccData);
		return "success";
	}
	@RequestMapping(value="/GetAllApplications" ,  method=RequestMethod.GET)//success tested
    public  List<Application> myapplications() {
		
		return clerkService.getAllApplications();
		
	}
	@RequestMapping(value="/GetAllRejectedApplications" ,  method=RequestMethod.GET)//success tested
    public  List<Application> allReajectedpplications() {
		
		List<Application> rejappli=clerkService.getAllApplications().stream().filter(p->p.getApplicationStatus()==0).toList();
		return rejappli;
	}
	@RequestMapping(value="/GetAllacceptedApplications" ,  method=RequestMethod.GET)//success tested
    public  List<Application> allacceptedpplications() {
		
		List<Application> acceptedappli=clerkService.getAllApplications().stream().filter(p->p.getApplicationStatus()==1).toList();
		return acceptedappli;
	}
	@RequestMapping(value="/GetAllPendingApplications" ,  method=RequestMethod.GET)//success tested
    public  List<Application> allPendingapplications() {
		
		List<Application> pendingappli=clerkService.getAllApplications().stream().filter(p->p.getApplicationStatus()==2).toList();
		return pendingappli;
	}
	@RequestMapping(value="/GetAllCanceledApplications" ,  method=RequestMethod.GET)//success tested
    public  List<Application> allCanceledapplications() {
		
		List<Application> canceledappli=clerkService.getAllApplications().stream().filter(p->p.getApplicationStatus()==3).toList();
		return canceledappli;
	}
	
	@RequestMapping(value="/GetCustomerDetailsById/{custId}" ,  method=RequestMethod.GET)
	public Customer getCustomerDetails(@PathVariable String custId) {
		return clerkService.getgetCustomerDetailsById(custId);
	}
	@RequestMapping(value="/GetLoanDetailsById/{loanId}" ,  method=RequestMethod.GET)
	public ActiveLoans getLoanDetails(@PathVariable int loanId) {
		return clerkService.getLoanDetailsById(loanId);
	}
	@RequestMapping(value="/GetAllLoanDetails" ,  method=RequestMethod.GET)
	public List<ActiveLoans> getLoanDetails() {
		return clerkService.getLoanDetails();
	}


	
	
	
	
}
