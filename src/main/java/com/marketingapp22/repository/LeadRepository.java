package com.marketingapp22.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp22.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long>{

}
