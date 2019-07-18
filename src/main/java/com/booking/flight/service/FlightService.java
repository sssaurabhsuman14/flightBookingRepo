package com.booking.flight.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.flight.entity.Flight;
import com.booking.flight.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	public List<FlightModel> searchFlights(FlightModel model){
		
		String source;
		
		String destination;
		
		LocalDate date ;
		
		//need to change DTO to entity
		
		List<Flight> flights = flightRepository.findBySourceAndDestinationAndTime(source, destination, date);
		
		return  flights;
		
	}

}
