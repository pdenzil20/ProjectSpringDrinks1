package com.example.SpringDrinks.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.SpringDrinks.domain.Drink;
import com.example.SpringDrinks.repo.DrinkRepo;

@RunWith(MockitoJUnitRunner.class)

public class DrinkServiceUnitTest {

	// Injecting Mocks to the service class
	@InjectMocks
	private DrinkService service;

	// Mocking the repository class as we don't want to depend on the Repo class
	// itself
	@Mock
	private DrinkRepo repo;

	@Test
	
	public void createTest() {
		Drink input = new Drink("Glenllivet 15yr", "Single Malt", "43%","Rich & Smooth", 70);
		Drink output = new Drink(1L,"Glenllivet 15yr", "Single Malt", "43%","Rich & Smooth", 70);
		
	Mockito.when(this.repo.save(input)).thenReturn(output);
	assertEquals(output, this.service.create(input));
	
	Mockito.verify(this.repo, Mockito.times(1)).save(input);
		
		
	}
}
