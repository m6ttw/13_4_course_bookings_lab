package com.codeclan.example.coursebooking;

import com.codeclan.example.coursebooking.models.Customer;
import com.codeclan.example.coursebooking.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursebookingApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateCustomer(){
		Customer customer = new Customer("Bob", "Edinburgh", 30);
		customerRepository.save(customer);
	}
}
