package com.springboot.controllers;


import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springboot.entities.Fund;
import com.springboot.entities.Investor;
import com.springboot.repositories.FundRepository;
import com.springboot.repositories.InvestorRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class FundController {
	
	@Autowired
	FundRepository fundRepository;
	
	@Autowired
	InvestorRepository investorRepository;
	
	@GetMapping("investors/{investorId}/getFund")
	public List<Fund> getAllFundByInvestorID(@PathVariable (value = "investorId") int investorId){
		return fundRepository.findByInvestorId(investorId);
	}
	
	@PostMapping("investors/{investorId}/createFund")
	public Fund createInvestor(@PathVariable Long investorId, @Valid @RequestBody Fund fund){
		List<Investor> tempInvestor = investorRepository.findAll();
		
		for(Investor inv : tempInvestor){
			if(inv.getId() == investorId){
				fund.setInvestor(inv);
			}
		}
	return fundRepository.save(fund);
	};

}
