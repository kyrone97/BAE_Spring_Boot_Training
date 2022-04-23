package com.qa.baespring.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.baespring.domain.User;
import com.qa.baespring.service.UserService;

@WebMvcTest
public class UserControllerUnitTest {
	

	@Autowired
	private MockMvc mvc;
	
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private UserService service;
	
	
	@Test // test are void because they dont return anything
	public void createTest() throws Exception {
		
	User entry = new User("Jim", "Jones", "JJones1",24);
	String entryAsJSON = mapper.writeValueAsString(entry);
	
	User result = new User(2L, "Jim", "Jones", "JJones1",24);
	String resultAsJSON = mapper.writeValueAsString(result);
	
	
	// Takes control of the mock service
	// Tell it what to return
	Mockito.when(service.create(entry)).thenReturn(result);
	
	mvc.perform(post("/user/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isCreated())
			.andExpect(content().json(resultAsJSON));
	
	}
	
	@Test
	public void getAllTest() throws Exception{
		User user = new User(1L,"Jim", "Jones", "JJones1",24);
		List<User> output = new ArrayList<>();
		output.add(user);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/user/getAll")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json(outputAsJSON));
		
			
	}
	
	@Test
	public void getById()throws Exception {
		User user1 = new User(1L,"Jim", "Jones", "JJones1",24);
		String output1AsJSON = mapper.writeValueAsString(user1);
		
		mvc.perform(get("/user/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(output1AsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {
		User user2 = new User("Tom", "Jones", "JJones1",24); // Create a java object representing your update object
		String output2AsJSON = mapper.writeValueAsString(user2); // Convert that to JSON

		User result1 = new User(1L, "Tom", "Jones", "JJones1",24); // Create a java object representing what you expect to get back
		String resul1tAsJSON = mapper.writeValueAsString(result1); // Convert that to JSON

		mvc.perform(put("/user/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(output2AsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(resul1tAsJSON));// Send your request and check for the right response code and content
	}

}
