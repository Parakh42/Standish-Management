package com.springboot.entities;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//import org.hibernate.annotations.Cascade;
import javax.persistence.*;

@Entity
public class Client {
	
	private int id;
	private String name;
	private String description;
	private Set<Investor> investors;
	
	public Client() {
	}
	
	public Client(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	
	public Client(String name, String description, Investor... investors) {
		this.name = name;
		this.description = description;
		this.investors = Stream.of(investors).collect(Collectors.toSet());
		this.investors.forEach(x -> x.setClient(this));
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy = "client",cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<Investor> getInvestors() {
		return investors;
	}

	public void setInvestors(Set<Investor> investors) {
		this.investors = investors;
	}
	
//	public void addInvestor(Investor inv){
//		investors.add(inv);
//		inv.setClient(this);
//	}
	
	
}
