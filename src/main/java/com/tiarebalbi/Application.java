package com.tiarebalbi;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import com.tiarebalbi.entity.Customer;
import com.tiarebalbi.entity.QCustomer;
import com.tiarebalbi.repository.CustomerRepository;

@Configuration
@ComponentScan({"com.tiarebalbi"})
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		long total = this.repository.count(QCustomer.customer.lastVisit.year().eq(year));
		
		Assert.isTrue(total == 2, "Should have 2 customer");

	}

}
