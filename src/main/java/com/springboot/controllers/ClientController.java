package com.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.entities.Client;
import com.springboot.repositories.ClientRepository;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ClientController {

	@Autowired
	ClientRepository clientRepository;

	@GetMapping("/clients")
	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	@PostMapping("/createClient")
	public void createClient(@Valid @RequestBody Client client) {
		clientRepository.save(client);
	}

	@PutMapping("/clients/{clientId}")
	public void updateClient(@PathVariable(value = "clientId") int clientId, @Valid @RequestBody Client clientRequest) {
		// System.out.println("Entered---------------------");
		Client temp = clientRepository.findById(clientId);
		temp.setName(clientRequest.getName());
		temp.setDescription(clientRequest.getDescription());
		clientRepository.save(temp);
	}

}
