package com.booking.flight.controllers.test;

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
	Optional<List<Flight>> flights = Optional.of(new ArrayList());



	@Test
	public void searchFlights()
	{
		createFlightModel();

		createFlight();

		Mockito.when(flightRepository.findBySourceAndDestinationOrderByFareAsc(flightModel.getSource(), flightModel.getFlightSortBy())).thenReturn( flights);

		ResponseEntity responseEntity= new ResponseEntity(flights, HttpStatus.OK);

		Assert.assertNotNull(flights);

	}


	@Before
	public void createFlightModel() {


		flightModel.setSource("pune");
		flightModel.setDestination("mumbai");
		flightModel.setFlightDate(LocalDate.now());
		flightModel.setFlightSortBy("fare");

	}

	@Before 
	public void createFlight() {


		flight.setDestination("mumbai");
		flight.setSource("pune");

	}

	@Before
	public void createFlights() {
		flights.get().add(flight);
	}
}
