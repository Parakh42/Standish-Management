package com.springboot.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springboot.entities.Client;
import com.springboot.entities.Investor;
import com.springboot.repositories.ClientRepository;
import com.springboot.repositories.InvestorRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class InvestorController {
	
	@Autowired
	private InvestorRepository investorRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/investors")
	public List<Investor> getAllInvestor(){
		return investorRepository.findAll();
	}
	
	
	@GetMapping("clients/{clientId}/investors")
	public List<Investor> getAllInvestorByClientID(@PathVariable (value = "clientId") int clientId){
		return investorRepository.findByClientId(clientId);
	}
	
	@PostMapping("clients/{clientId}/createInvestor")
	public Investor createInvestor(@PathVariable Long clientId, @Valid @RequestBody Investor investor){
		List<Client> tempClient = clientRepository.findAll();
		
		for(Client cl : tempClient){
			if(cl.getId() == clientId){
				investor.setClient(cl);
			}
		}
	return investorRepository.save(investor);
	};

}
