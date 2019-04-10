package com.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.entities.Investor;

public interface InvestorRepository extends JpaRepository<Investor, Integer>{
	
	List<Investor> findByClientId(int clientId);
	
}
