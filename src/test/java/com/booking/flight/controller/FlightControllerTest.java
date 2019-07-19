package com.booking.flight.controller;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.booking.flight.controller.FlightController;
import com.booking.flight.entity.Flight;
import com.booking.flight.model.FlightModel;
import com.booking.flight.repository.FlightRepository;
import com.booking.flight.service.FlightService;
import com.booking.flight.utils.ObjectUtility;
import com.booking.flight.validation.FlightNotAvailableException;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class FlightControllerTest {

	@InjectMocks
	FlightController flightController;

	@Mock
	FlightService flightService;

	@Mock
	FlightRepository flightRepository;

	@Autowired
	FlightModel flightModel = new FlightModel();
	@Autowired
	Flight flight = new Flight();
	@Autowired
	List<Flight> flights =  new ArrayList<>();

	@Before
	public void setUp() {


		flightModel.setSource("pune");
		flightModel.setDestination("mumbai");
		flightModel.setFlightDate(LocalDate.now());
		flightModel.setFlightSortBy("fare");

		flight.setDestination("mumbai");
		flight.setSource("pune");
		flights.add(flight);

	}

	@Test
	public void searchFlights() throws FlightNotAvailableException
	{

		Mockito.when(flightService.searchFlights(flightModel)).thenReturn(flights);

		List<Flight> list = flightService.searchFlights(flightModel);

		assertEquals(flights, list);
		Assert.assertNotNull(flights);

	}




	public void addFlight() {


	}
}
