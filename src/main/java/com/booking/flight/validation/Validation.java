package com.booking.flight.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.booking.flight.repository.FlightRepository;

@Component
public class Validation {
	
	public boolean validateFlightByAvailableSeats(Integer availableSeats , Integer requestedSeats) {
				
	if(availableSeats !=  null && requestedSeats != null && availableSeats <= requestedSeats) {
		return true;
	}
		return false;
	}

}
