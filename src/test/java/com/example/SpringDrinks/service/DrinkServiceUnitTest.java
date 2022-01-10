package com.example.SpringDrinks.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

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
	
	@Test
	public void updateTest() {
		Drink input = new Drink("Jura 12", "Single Malt", "30%", "Spicy",35);
		Drink output = new Drink(1L, "Jura 12", "Single Malt", "30%", "Spicy",35);
		Optional<Drink> existing= Optional.of(new Drink (1L,"JD 12", "Blended", "40%", "Sweet",70));
		
		Mockito.when(this.repo.findById(1L)).thenReturn(existing);
		
		Mockito.when(this.repo.saveAndFlush(output)).thenReturn(output);
		
		assertEquals(output,this.service.update(1L, input));
	}
	
	
	
	
//@Test
//	
//	public void getAllTest() {
//		Drink input = new Drink("Glenllivet 15yr", "Single Malt", "43%","Rich & Smooth", 70);
//		Drink output = new Drink(1L,"Glenllivet 15yr", "Single Malt", "43%","Rich & Smooth", 70);
//		
//	Mockito.when(this.repo.save(input)).thenReturn(output);
//	assertEquals(output, this.service.getAll(input));
//	
//	Mockito.verify(this.repo, Mockito.times(1)).save(input);
//		
//		
//	}
}
