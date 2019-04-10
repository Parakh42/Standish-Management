package com.springboot.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.entities.Fund;

public interface FundRepository extends JpaRepository<Fund, Integer> {
	
	List<Fund> findByInvestorId(int investorId);

}
