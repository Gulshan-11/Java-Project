package com.oracle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationTemp;
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
import com.oracle.entity.ApplicationType;
import com.oracle.entity.Customer;
import com.oracle.entity.DocumentRetrievalData;
import com.oracle.entity.Nominee;
import com.oracle.service.ManagerService;

@RestController
@CrossOrigin
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	@RequestMapping(value="/approve/{userName}",method=RequestMethod.POST)//success
	public boolean approveLoan(@PathVariable String userName,@RequestBody String applyId ) {
        ObjectMapper obj=new ObjectMapper();
        JsonNode jn;
		try {
			jn = obj.readTree(applyId);
			String applicaionId=jn.get("applicationId").asText();
			managerService.approveLoanService(userName, applicaionId);
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
	public boolean RejectLoan(@PathVariable String userName,@RequestBody String data ) {
	     ObjectMapper obj=new ObjectMapper();
	        JsonNode jn;
			try {
				jn = obj.readTree(data);
				String applicaionId=jn.get("applicationId").asText();
				String rejectedReason=jn.get("rejectReason").asText();
				managerService.rejectService(userName, applicaionId,rejectedReason);			} catch (JsonMappingException e) {
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
		List<Application> applyData= managerService.getAllApplicationService();
		List<Application> rejectedApplications=applyData.stream().filter(p->p.getApplicationStatus()==0).toList();
		
		return rejectedApplications;
	}
	@RequestMapping(value="/ApllicationsAccept",method=RequestMethod.GET)
	public List<Application>getAcceptedAppliactions() {
		List<Application> applyData= managerService.getAllApplicationService();
		List<Application> acceptedApplications=applyData.stream().filter(p->p.getApplicationStatus()==1).toList();
		
		return acceptedApplications;
	}
	@RequestMapping(value="/ApllicationsPending",method=RequestMethod.GET)
	public List<Application>getPendingAppliactions() {
		List<Application> applyData= managerService.getAllApplicationService();
		List<Application> pendingApplications=applyData.stream().filter(p->p.getApplicationStatus()==2).toList();
		
		return pendingApplications;
	}
	@RequestMapping(value="/ApplicationDetails",method=RequestMethod.GET)
	public List<Application> getApplications(){
		return managerService.getAllApplicationService();
	}
	
	@RequestMapping(value="/viewNomineeeDetails/{applyId}",method=RequestMethod.GET)
    public Nominee nomineeDetails(@PathVariable String applyId) {
		return managerService.getNomineeDetailsService(applyId);		
	}
	@RequestMapping(value="/viewDetails/{applyid}",method=RequestMethod.GET)
	public Customer getCustomer(@PathVariable String applyid) {
		String custId=managerService.getCustomerIdService(applyid);
		        return  managerService.getCustomerDetailsService(custId);   
		
		
	} 
	
	@RequestMapping(value="/getDocuments/{applicationID}",method=RequestMethod.POST)
	public List<DocumentRetrievalData> getDocumentsByApplyId(@PathVariable String applicationID){
		//String custId=managerService.getCustomerIdService(at.getApplicationNum());
		return managerService.getDocumentDataService(applicationID);
		
	}
}
