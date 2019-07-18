package com.booking.flight.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.flight.entity.Flight;
import com.booking.flight.model.FlightModel;
import com.booking.flight.service.FlightService;
import com.booking.flight.validation.FlightNotAvailableException;
import com.booking.flight.validation.InvalidFlightDetailsException;

@RestController
@RequestMapping("/flights")
public class FlightController {


	@Autowired
	FlightService flightService;
	
	private final static String ERR_MSG = " INVALID DATA, MISSING PARAMETER : ";
	
	@PostMapping("/allFlights")
	public ResponseEntity<?> searchFlights(@RequestBody FlightModel model)
	{
		List<Flight> flights =  new ArrayList<>();

			  try 
			  {
				validateFlightDetails(model);
				flights = flightService.searchFlights(model);
				
			} 
			 catch (InvalidFlightDetailsException | FlightNotAvailableException e) {
				 return new ResponseEntity<>("Invalid Entry : ",HttpStatus.BAD_REQUEST);
			}

		return new ResponseEntity<>(flights,HttpStatus.OK);
		
	}
	
	private static void validateFlightDetails(FlightModel flightModel) throws InvalidFlightDetailsException
	{
		if(StringUtils.isEmpty(flightModel.getSource()))
				throw new InvalidFlightDetailsException(ERR_MSG+" SOURCE");
		
		if(StringUtils.isEmpty(flightModel.getDestination()))
			throw new InvalidFlightDetailsException(ERR_MSG+" DESTINATION");
		
		if(StringUtils.isEmpty(flightModel.getFlightDate()))
			throw new InvalidFlightDetailsException(ERR_MSG+" Flight Date");
		
		
	}

}
