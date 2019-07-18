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

import com.booking.flight.entity.Flight;
import com.booking.flight.model.FlightModel;
import com.booking.flight.repository.FlightRepository;

@Service
public class FlightService implements Comparable{

	@Autowired
	FlightRepository flightRepository;

	public List<Flight> searchFlights(FlightModel model){

		String source = model.getSource();

		String destination = model.getDestination();		

		//need to change DTO to entity

		Flight flight =  new Flight();

		Optional<List<Flight>> flights = flightRepository.findBySourceAndDestination(source, destination);


		if(flights.isPresent())
		{
			List<FlightModel> models = new ArrayList<FlightModel>();
			BeanUtils.copyProperties(flights.get(), models);


			return flights.get();
		}			
		else {
			return new ArrayList<Flight>();
		}

	}


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

	public List<Flight> filterFlights(List<Flight> flights, String flightSortBy){
		Map travelTimes = new HashMap();
		List sortedFlights = new ArrayList();
		if (flightSortBy == "travelTime") {
			travelTimes = this.travelTimeCalculator(flights);
		}
		switch(flightSortBy)
		{
		case "departure":
			sortedFlights = flightRepository.findByOrderByDepartureAsc();

			break;

		case "travelTime":
			// TODO: need to look in this				

			break;

		default:
			sortedFlights = flightRepository.findByOrderByFareAsc();

		}

		return sortedFlights;

	}

	public Map travelTimeCalculator(List<Flight> flights) {
		Map travelTimes = new HashMap();
		for(Flight flight: flights) {
			int time = Integer.parseInt(flight.getDeparture())- Integer.parseInt(flight.getArrival());
			travelTimes.put(flight.getFlightId(), time);
		}
		return travelTimes;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
