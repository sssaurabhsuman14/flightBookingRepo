package com.booking.flight.service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.booking.flight.entity.Flight;
import com.booking.flight.model.FlightModel;
import com.booking.flight.repository.FlightRepository;
import com.booking.flight.validation.FlightNotAvailableException;

@Service
public class FlightService
{

	@Autowired
	FlightRepository flightRepository;



	/*
	 * FlightModel toModel(Flight flight) {
	 * 
	 * FlightModel model = new FlightModel(); model.setArrival(flight.getArrival());
	 * model.setAvailableSeats(flight.getAvailableSeats());;
	 * model.setDeparture(flight.getDeparture());
	 * model.setDestination(flight.getDestination());
	 * model.setFare(flight.getFare());
	 * model.setFlightNumber(flight.getFlightNumber());
	 * model.setSource(flight.getSource());
	 * model.setTotalSeats(flight.getTotalSeats());
	 * 
	 * return model; }
	 * 
	 * Flight toEntity(FlightModel flight) {
	 * 
	 * Flight model = new Flight(); model.setArrival(flight.getArrival());
	 * model.setAvailableSeats(flight.getAvailableSeats());;
	 * model.setDeparture(flight.getDeparture());
	 * model.setDestination(flight.getDestination());
	 * model.setFare(flight.getFare());
	 * model.setFlightNumber(flight.getFlightNumber());
	 * model.setSource(flight.getSource());
	 * model.setTotalSeats(flight.getTotalSeats());
	 * 
	 * return model; }
	 */


	
	public List<Flight> searchFlights(FlightModel model) throws FlightNotAvailableException{
		
		
		List<Flight> flightList = new ArrayList<Flight>();

		Optional<List<Flight>> flights = filterFlights(model,model.getFlightSortBy());
		
		boolean isFlightList = flights.isPresent();
		
		if(isFlightList)
		{
			flightList = flights.get();
			System.out.println(flightList);
		}
		else
		{
			throw new FlightNotAvailableException("No Flights Available");
		}
		
		return flightList;
	
	}

	private Optional<List<Flight>> filterFlights(FlightModel model, String flightSortBy) {
		
		Optional<List<Flight>> flightList = null;
		
		switch(flightSortBy)
		{
		case "fare":
			flightList = flightRepository.findBySourceAndDestinationOrderByFareAsc(model.getSource(), model.getDestination());
			break;

		}

		return flightList;
	}
}
