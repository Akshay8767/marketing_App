package com.marketingapp22.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp22.entity.Lead;
import com.marketingapp22.repository.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {

	@Autowired
	private LeadRepository leadRepo;
	
	// http://localhost:8080/api/leads
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> lead = leadRepo.findAll();
		return lead;
	}
	
	@PostMapping
	public void createLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	// http://localhost:8080/api/leads/9
	@DeleteMapping("{id}")
	public void deleteLead(@PathVariable("id") long id) {
		leadRepo.deleteById(id);
	}
	
//	//http://localhost:8080/api/leads/1
//	@PutMapping("{id}")
//	public void updateLead(
//			@PathVariable("id") long id,
//			@RequestBody LeadDto dto
//			) {
//		
//		
//	}
	
}
