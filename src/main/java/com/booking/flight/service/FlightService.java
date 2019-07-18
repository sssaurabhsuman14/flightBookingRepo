package com.booking.flight.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.fight.model.FlightModel;
import com.booking.flight.entity.Flight;
import com.booking.flight.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	public List<FlightModel> searchFlights(FlightModel model){
		
		String source = model.getSource();
		
		String destination = model.getDeparture();
		
		//need to change DTO to entity
		
		Flight flight =  new Flight();
		BeanUtils.copyProperties(model, flight);
		
		Optional<List<Flight>> flights = flightRepository.findBySourceAndDestination(source, destination);
		
		
		if(flights.isPresent())
		{
			List<FlightModel> models = new ArrayList<FlightModel>();
			BeanUtils.copyProperties(flights.get(), models);
			
			return models;
		}			
		else {
			return new ArrayList<FlightModel>();
		}
		
	}

}
