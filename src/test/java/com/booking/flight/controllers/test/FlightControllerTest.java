package com.booking.flight.controllers.test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.booking.flight.controller.FlightController;
import com.booking.flight.model.FlightModel;
import com.booking.flight.service.FlightService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class FlightControllerTest {
	
	@InjectMocks
	FlightController flightController;
	
	@Mock
	FlightService flightService;
	
	public void searchFlights()
	{
		FlightModel flightModel = createFlightModel();

		ResponseEntity responseEntity= new ResponseEntity(offers, HttpStatus.OK);

		//Verify request succeed
		Assert.assertEquals(200, responseEntity.getStatusCodeValue());

		Assert.assertEquals(true, (responseEntity.hasBody()));

	}
	
	
	private FlightModel createFlightModel() {
		FlightModel flightModel = new FlightModel();
		flightModel.set
		
		return flightModel;
	}

}
