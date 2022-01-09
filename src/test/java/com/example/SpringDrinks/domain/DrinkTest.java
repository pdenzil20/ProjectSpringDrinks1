package com.example.SpringDrinks.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class DrinkTest {

	@Test
	public void testEquals() {

		EqualsVerifier.forClass(Drink.class).usingGetClass().verify();
	}

	@Test
	public void noIdConstructor() {
		Drink drink = new Drink("BlendersPride", "Blended Whiskey","42%","Bitter Sweet", 35);
		assertNotNull(drink.getName());
		assertNotNull(drink.getType());
		assertNotNull(drink.getAlcoholpercentage());
		assertNotNull(drink.getTaste());
		assertNotNull(drink.getQuantity());

		assertEquals(drink.getName(), "BlendersPride");
		assertEquals(drink.getType(), "Blended Whiskey");
		assertEquals(drink.getAlcoholpercentage(), "42%");
		assertEquals(drink.getTaste(), "Bitter Sweet");
		assertEquals(drink.getQuantity(), 35);
	}
	
	@Test
	public void settersTest() {
		Drink drink = new Drink();
		
		drink.setName("Jura");
		drink.setType("Single Malt Whiskey");
		drink.setAlcoholpercentage("43%");
		drink.setTaste("Strong");
		drink.setQuantity(70);
		
		assertNotNull(drink.getName());
		assertNotNull(drink.getType());
		assertNotNull(drink.getAlcoholpercentage());
		assertNotNull(drink.getTaste());
		assertNotNull(drink.getQuantity());

		assertEquals(drink.getName(), "Jura");
		assertEquals(drink.getType(), "Single Malt Whiskey");
		assertEquals(drink.getAlcoholpercentage(), "43%");
		assertEquals(drink.getTaste(), "Strong");
		assertEquals(drink.getQuantity(), 70);
		
	}

}