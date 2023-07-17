package com.marketingapp22.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp22.entity.Lead;
import com.marketingapp22.service.LeadService;
import com.marketingapp22.util.EmailService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	//  http://localhost:8080/view
	@RequestMapping("/view")
	public String viewLeadPage() {
		
		return "create_leads";	// create_leads is a view page name
		
		// here return acts as a requestDispatcher
	}
	
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute Lead lead,ModelMap model) {
		leadService.saveLead(lead);
		emailService.sendEmail(lead.getEmail(),"welcome","test");
		model.addAttribute("msg","Lead Successfully Saved!!");
		return "create_leads";
		
	}
	// http://localhost:8080/listAll
	@RequestMapping("/listAll")
	public String getAllLeads(ModelMap model){
		List<Lead> leads=leadService.getLeads();
		model.addAttribute("leads", leads);
		
		return "list_leads";
		
	}
	
	@RequestMapping("/delete")
	public String deleteLeadById(@RequestParam("id") long id,ModelMap model) {
		leadService.deleteLead(id);
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads",leads);
		return "list_leads";
	}
	
	@RequestMapping("/update")
	public String updateLeadById(@RequestParam("id") long id, ModelMap model) {
		Lead lead=leadService.getLeadById(id);
		model.addAttribute("lead", lead);
		return "update_lead";
		
	}
	
	@RequestMapping("/updateLead")
	public String updateOneLead(Lead lead, ModelMap model) {
		leadService.saveLead(lead);
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
}
