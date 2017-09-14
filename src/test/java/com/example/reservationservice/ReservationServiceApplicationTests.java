package com.example.reservationservice;

import com.example.reservationservice.controller.ReservationRestController;
import com.example.reservationservice.entity.Reservation;
import com.example.reservationservice.repository.ReservationRepository;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

@SpringBootTest (classes = ReservationServiceApplication.class)
@RunWith(SpringRunner.class)

public class ReservationServiceApplicationTests {

//	@MockBean
//	ReservationRepository reservationRepository;
//
//	@Autowired
//	ReservationRestController reservationRestController;
//
//
//	@Before
//	public void before() throws Throwable{
//		RestAssuredMockMvc.standaloneSetup(this.reservationRestController);
//
//		Mockito.when(this.reservationRepository.findAll())
//				.thenReturn(Arrays.asList(new Reservation(1L, "Dan"),
//						new Reservation(2L, "Jane")));
//	}

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void before() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void contextLoads() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/reservations"))
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
