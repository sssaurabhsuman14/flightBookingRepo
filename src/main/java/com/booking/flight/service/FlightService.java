package com.booking.flight.service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
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
		
		List<Flight> flightListToday = new ArrayList<Flight>();

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
		
		if(model.getFlightDate().isEqual(LocalDate.now()))
		{
			for(Flight flight : flightList)
			{
				int compareValue = LocalTime.now().compareTo(flight.getDeparture());
				if(compareValue < 1)
				{
							System.out.println(flight);
							flightListToday.add(flight);
				}
				
			}				
		}
		else
		{
			flightListToday = flightList;
		}
		
		return flightListToday;
	
	}

	private Optional<List<Flight>> filterFlights(FlightModel model, String flightSortBy) {
		
		switch(flightSortBy)
		{
			case "fare":
			return flightRepository.findBySourceAndDestinationOrderByFareAsc(model.getSource(), model.getDestination());
			
			case "departure":
				return flightRepository.findBySourceAndDestinationOrderByDepartureAsc(model.getSource(), model.getDestination());
				
			case "seats":
				return flightRepository.findBySourceAndDestinationOrderByAvailableSeatsDesc(model.getSource(), model.getDestination());

		}

		return null;
	}
	
	public Optional<Flight> getFlight (Long flightId) {
		Optional<Flight> flight;
		flight = flightRepository.findById(flightId);
		return flight;
	}
	
	public boolean updateFlightByNumberOfSeats(Flight flight, Integer numberOfSeatsBooked) {
		
		if( flight != null) {
			Integer updatedAvailableSeats = flight.getAvailableSeats() - numberOfSeatsBooked;
			flight.setAvailableSeats(updatedAvailableSeats);
			flightRepository.save(flight);
			return true;
		}
		return false;
	}

	public Optional<Flight> findById(Long fligtId) {
		return flightRepository.findById(fligtId);
	}
}
