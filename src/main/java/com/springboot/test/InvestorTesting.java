package com.springboot.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.springboot.entities.Client;
import com.springboot.repositories.ClientRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InvestorTesting {
	
	@Autowired
	private ClientRepository clirepo;
	
	@Test
	public void whenFindById(){
		Client client = clirepo.findById(1);
		assertThat(client.getName(),is("Apple"));
	}
	
	
}
