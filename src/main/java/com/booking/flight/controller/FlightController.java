package com.booking.flight.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.flight.entity.Flight;
import com.booking.flight.entity.User;
import com.booking.flight.model.FlightModel;
import com.booking.flight.model.PassengerModel;
import com.booking.flight.service.FlightService;
import com.booking.flight.validation.FlightNotAvailableException;
import com.booking.flight.validation.InvalidFlightDetailsException;
import com.booking.flight.validation.UserNotFoundException;
import com.booking.flight.validation.Validation;

@RestController
@RequestMapping("/flights")
public class FlightController {


	@Autowired
	FlightService flightService;

	@Autowired
	Validation validation;

	private final static String ERR_MSG = " INVALID DATA, MISSING PARAMETER : ";

	@PostMapping("/searchFlights")
	public ResponseEntity<?> searchFlights(@RequestBody FlightModel model)
	{
		List<Flight> flights =  new ArrayList<>();

		try 
		{
			validation.validateFlightDetails(model);
			flights = flightService.searchFlights(model);

		} 
		catch (InvalidFlightDetailsException | FlightNotAvailableException e) {
			return new ResponseEntity<>("Invalid Entry : "+e.getMessage(),HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(flights,HttpStatus.OK);

	}



	@PostMapping("/add")
	public ResponseEntity<String> addFlight(@RequestParam(value="userId") Long userId, @RequestBody Flight flight) {

		try {
			validation.validateAddFlightDetails(flight);

			if(validation.validateUserRole(userId))
			{
				String requestToAddFlight = flightService.requestToAddFlight(flight, userId);

				return new ResponseEntity<String>(requestToAddFlight, HttpStatus.OK);

			}
			else
			{
				return new ResponseEntity<String>("You don't have rights to add new flight ", HttpStatus.OK);
			}
		} catch (InvalidFlightDetailsException | UserNotFoundException e) {
			return new ResponseEntity<>("Invalid request : "+e.getMessage(),HttpStatus.BAD_REQUEST);
		}

	}
}
