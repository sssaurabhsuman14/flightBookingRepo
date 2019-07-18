package com.booking.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.flight.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {
	

	FlightService flightService;
	
	@GetMapping("/allFlights")
	public ResponseEntity<?> searchFlights(@ResponseBody FlightModel flightModel)
	{
		validateFlightDetails(flightModel);
		
		return new ResponseEntity<List<Flight>>(flightService.searchFlights(flightModel,HttpStatus.OK);
		
	}
	
	private static void validateFlightDetails(FlightModel flightModel)
	{
		
		
	}

}
