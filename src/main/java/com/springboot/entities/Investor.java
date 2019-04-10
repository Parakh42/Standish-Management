package com.springboot.entities;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Investor {

	private int id;
	private String name;

	private Client client;

	private List<Fund> funds;

	public Investor() {

	}

	public Investor(String name) {
		this.name = name;
	}

	public Investor(String name, Fund... funds) {
		this.name = name;
		this.funds = Stream.of(funds).collect(Collectors.toList());
		this.funds.forEach(x -> x.setInvestor(this));
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

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@OneToMany(mappedBy = "investor", cascade = CascadeType.ALL)
	public List<Fund> getFunds() {
		return funds;
	}

	public void setFunds(List<Fund> funds) {
		this.funds = funds;
	}

}
