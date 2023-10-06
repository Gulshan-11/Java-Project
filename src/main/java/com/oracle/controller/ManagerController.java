package com.oracle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.entity.Application;
import com.oracle.entity.Customer;
import com.oracle.entity.Nominee;
import com.oracle.service.ManagerService;

@RestController
@CrossOrigin
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	@RequestMapping(value="/approve/{userName}",method=RequestMethod.GET)//success
	public boolean approveLoan(@PathVariable String userName,@RequestBody String applyId ) {
        ObjectMapper obj=new ObjectMapper();
        JsonNode jn;
		try {
			jn = obj.readTree(applyId);
			String applicaionId=jn.get("applyid").asText();
			managerService.approveLoan(userName, applicaionId);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return true;
	}
	@RequestMapping(value="/reject/{userName}",method=RequestMethod.POST)
	public boolean RejectLoan(@PathVariable String userName,@RequestBody String applyId ) {
	     ObjectMapper obj=new ObjectMapper();
	        JsonNode jn;
			try {
				jn = obj.readTree(applyId);
				String applicaionId=jn.get("applyid").asText();
				managerService.reject(userName, applicaionId);			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return true;
	}
	@RequestMapping(value="/ApllicationsReject",method=RequestMethod.GET)
	public List<Application>getRejectedAppliactions() {
		List<Application> applyData= managerService.getAllApplication();
		List<Application> rejectedApplications=applyData.stream().filter(p->p.getApplicationStatus()==0).toList();
		
		return rejectedApplications;
	}
	@RequestMapping(value="/ApllicationsAccept",method=RequestMethod.GET)
	public List<Application>getAcceptedAppliactions() {
		List<Application> applyData= managerService.getAllApplication();
		List<Application> acceptedApplications=applyData.stream().filter(p->p.getApplicationStatus()==1).toList();
		
		return acceptedApplications;
	}
	@RequestMapping(value="/ApllicationsPending",method=RequestMethod.GET)
	public List<Application>getPendingAppliactions() {
		List<Application> applyData= managerService.getAllApplication();
		List<Application> pendingApplications=applyData.stream().filter(p->p.getApplicationStatus()==2).toList();
		
		return pendingApplications;
	}
	@RequestMapping(value="/ApplicationDetails",method=RequestMethod.GET)
	public List<Application> getApplications(){
		return managerService.getAllApplication();
	}
	
	@RequestMapping(value="/viewNomineeeDetails/{applyId}",method=RequestMethod.GET)
    public Nominee nomineeDetails(@PathVariable String applyId) {
		return managerService.getNomineeDetails(applyId);		
	}
	@RequestMapping(value="/viewDetails/{applyid}",method=RequestMethod.GET)
	public Customer getCustomer(@PathVariable String applyid) {
		String custId=managerService.getCustomerId(applyid);
		        return  managerService.getCustomerDetails(custId);   
		
		
	} 
	
}
