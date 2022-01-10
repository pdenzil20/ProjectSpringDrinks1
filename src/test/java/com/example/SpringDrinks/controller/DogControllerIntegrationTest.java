package com.example.SpringDrinks.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.example.SpringDrinks.domain.Drink;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:drink-schema.sql","classpath:drink-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")

public class DogControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void createTest() throws Exception {
		Drink entry = new Drink("Jura", "Single", "38%", "Spicy", 35);
		Drink result = new Drink(2L, "Jura", "Single", "38%", "Spicy", 35);

		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);

		mvc.perform(post("/drink/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(resultAsJSON));

	}
	
	@Test
	public void updateTest() throws Exception { 
		
		Drink entry = new Drink("Jura", "Single", "38%", "Spicy", 35);
		Drink result = new Drink(1L, "Jura", "Single", "38%", "Spicy", 35);

		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);

		mvc.perform(put("/drink/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(resultAsJSON));
		
	}
	
	@Test
	public void readAllTest() throws Exception { 
		
		Drink existing = new Drink("Jura", "Single", "38%", "Spicy", 35);
		Drink result = new Drink(1L, "Jura", "Single", "38%", "Spicy", 35);

		String existingAsJSON = this.mapper.writeValueAsString(existing);
		String resultAsJSON = this.mapper.writeValueAsString(result);

		mvc.perform(get("/drink/readAll")
				.contentType(MediaType.APPLICATION_JSON)
				.content(existingAsJSON))
				.andExpect(status().isOk())
				.andExpect(content().json(resultAsJSON));
		
	}

	@Test
	public void deleteTest() throws Exception { 
		
		Drink entry = new Drink("Jura", "Single", "38%", "Spicy", 35);
		Drink result = new Drink(1L, "Jura", "Single", "38%", "Spicy", 35);

		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);

		mvc.perform(delete("/drink/delete/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isNotFound())
				.andExpect(content().json(resultAsJSON));
		
	}

}
