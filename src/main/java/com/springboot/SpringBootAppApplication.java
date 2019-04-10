package com.springboot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springboot.entities.Client;
import com.springboot.entities.Fund;
import com.springboot.entities.Investor;
import com.springboot.repositories.ClientRepository;
import com.springboot.repositories.FundRepository;
import com.springboot.repositories.InvestorRepository;
import com.springboot.test.InvestorTesting;

@SpringBootApplication
//@ComponentScan(basePackages={"com.springboot.repositories","com.springboot.entities","com.springboot.controllers","com.springboot.test"})
//@EntityScan("com.delivery.domain")
//@EnableJpaRepositories("com.springboot.repositories")
public class SpringBootAppApplication implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	InvestorRepository investorRepository;

	@Autowired
	FundRepository fundRepository;
	
//	@Autowired
//	InvestorTesting invTest;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Create some clients, investors and funds for populating on the page
		Set<Investor> invCli1 = new HashSet<Investor>();
		Client cli = new Client();
		cli.setName("Apple");
		cli.setDescription("Amazing");
		cli.setInvestors(invCli1);
		clientRepository.save(cli);

		Set<Investor> invCli2 = new HashSet<Investor>();
		Client cli1 = new Client();
		cli1.setName("Google");
		cli1.setDescription("Fun");
		cli1.setInvestors(invCli2);
		clientRepository.save(cli1);

		Investor inv = new Investor();
		List<Fund> funInv = new ArrayList<Fund>();
		inv.setName("Tim");
		inv.setClient(clientRepository.findById(cli.getId()));
		inv.setFunds(funInv);
		investorRepository.save(inv);
		cli.getInvestors().add(inv);

		Investor inv1 = new Investor();
		List<Fund> funInv1 = new ArrayList<Fund>();
		inv1.setName("John");
		inv1.setClient(clientRepository.findById(cli.getId()));
		inv1.setFunds(funInv1);
		investorRepository.save(inv1);
		cli.getInvestors().add(inv1);

		Investor inv2 = new Investor();
		List<Fund> funInv2 = new ArrayList<Fund>();
		inv2.setName("Tom");
		inv2.setClient(clientRepository.findById(cli.getId()));
		inv2.setFunds(funInv2);
		investorRepository.save(inv2);
		cli.getInvestors().add(inv2);

		Investor inv3 = new Investor();
		List<Fund> funInv3 = new ArrayList<Fund>();
		inv3.setName("Parakh");
		inv3.setClient(clientRepository.findById(cli1.getId()));
		inv3.setFunds(funInv3);
		investorRepository.save(inv3);
		cli1.getInvestors().add(inv3);

		Investor inv4 = new Investor();
		List<Fund> funInv4 = new ArrayList<Fund>();
		inv4.setName("Donald");
		inv4.setClient(clientRepository.findById(cli1.getId()));
		inv4.setFunds(funInv4);
		investorRepository.save(inv4);
		cli1.getInvestors().add(inv4);

		Fund fund = new Fund();
		fund.setAmount(1000.01);
		fund.setInvestor(inv);
		fundRepository.save(fund);
		inv.getFunds().add(fund);

		Fund fund1 = new Fund();
		fund1.setAmount(10001.01);
		fund1.setInvestor(inv);
		fundRepository.save(fund1);
		inv.getFunds().add(fund1);

		Fund fund2 = new Fund();
		fund2.setAmount(100022.01);
		fund2.setInvestor(inv1);
		fundRepository.save(fund2);
		inv1.getFunds().add(fund2);

		Fund fund3 = new Fund();
		fund3.setAmount(100033.01);
		fund3.setInvestor(inv1);
		fundRepository.save(fund3);
		inv1.getFunds().add(fund3);

		Fund fund4 = new Fund();
		fund4.setAmount(100044.01);
		fund4.setInvestor(inv2);
		fundRepository.save(fund4);
		inv2.getFunds().add(fund4);

		Fund fund5 = new Fund();
		fund5.setAmount(100055.01);
		fund5.setInvestor(inv3);
		fundRepository.save(fund5);
		inv3.getFunds().add(fund5);

		Fund fund6 = new Fund();
		fund6.setAmount(100066.01);
		fund6.setInvestor(inv4);
		fundRepository.save(fund6);
		inv4.getFunds().add(fund6);
		
		//
		//invTest.whenFindById();

	}

}
