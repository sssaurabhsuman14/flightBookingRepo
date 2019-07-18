package com.booking.flight.controller;

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
import com.booking.flight.validation.InvalidFlightDetailsException;

@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired 
	FlightService flightService;
	
	private final static String ERR_MSG = " INVALID DATA, MISSING PARAMETER : ";
	
	@PostMapping("/allFlights")
	public ResponseEntity<?> searchFlights(@RequestBody FlightModel flightModel)
	{
		
		try
		{
			validateFlightDetails(flightModel);
		}
		catch(InvalidFlightDetailsException e)
		{
			
		}
		
		return new ResponseEntity<List<Flight>>(flightService.searchFlights(flightModel),HttpStatus.OK);
		
	}
	
	private static void validateFlightDetails(FlightModel flightModel) throws InvalidFlightDetailsException
	{
		if(StringUtils.isEmpty(flightModel.getSource()))
				throw new InvalidFlightDetailsException(ERR_MSG+" SOURCE");
		
		
	}

}
