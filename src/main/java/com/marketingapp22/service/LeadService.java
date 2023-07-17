package com.marketingapp22.service;

import java.util.List;

import com.marketingapp22.entity.Lead;

public interface LeadService {

	void saveLead(Lead lead);

	List<Lead> getLeads();

	void deleteLead(long id);

	Lead getLeadById(long id);

}
