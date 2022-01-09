package com.example.SpringDrinks.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.SpringDrinks.domain.Drink;
import com.example.SpringDrinks.service.DrinkService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DrinkControllerUnitTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private DrinkService service;

	@Test
	public void createTest() throws Exception {
		Drink entry = new Drink("Jura L", "Single M","38%", "Spicy", 35);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.create(entry)).thenReturn(entry);
		
		mvc.perform(post("/drink/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(entryAsJSON));
		
	}
}
