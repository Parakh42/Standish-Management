package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.springboot.entities.Client;

//@Component
public interface ClientRepository extends JpaRepository<Client, Integer> {
	Client findById(int id);
}
