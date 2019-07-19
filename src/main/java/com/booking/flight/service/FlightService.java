package com.booking.flight.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.booking.flight.entity.Flight;
import com.booking.flight.model.FlightModel;
import com.booking.flight.repository.FlightRepository;
import com.booking.flight.utils.ObjectUtility;
import com.booking.flight.utils.OptionalUtils;
import com.booking.flight.validation.FlightNotAvailableException;
import com.booking.flight.validation.InvalidFlightDetailsException;

@Service
public class FlightService
{

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	OptionalUtils optionalUtils;

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
		
		if(model != null) {
		
			Optional<List<Flight>> flightsOptional = filterFlights(model,model.getFlightSortBy());
			
			flightList = (List<Flight>) OptionalUtils.checkOptional(flightsOptional);
			 
			List<Flight> availableFlights = new ArrayList<Flight>();
			
			for(Flight flight : flightList) {
				if(flight.getAvailableSeats() > 0) {
					availableFlights.add(flight);
				}
				
			}

			if(ObjectUtils.isEmpty(availableFlights))
			{
				throw new FlightNotAvailableException("No Flights Available");
			}

			
			if(model.getFlightDate().isEqual(LocalDate.now()))
			{
				for(Flight flight : availableFlights)
				{
					int compareValue = LocalTime.now().compareTo(flight.getDeparture());
					if(compareValue < 1)
					{
								flightListToday.add(flight);
					}
					
				}				
			}
			else
			{
				flightListToday = availableFlights;
			}
		}
		return flightListToday;
	
	}

	private Optional<List<Flight>> filterFlights(FlightModel model, String flightSortBy) {
		Optional<List<Flight>> optionalList = Optional.empty();
		switch(flightSortBy)
		{
			case "fare":
			return flightRepository.findBySourceAndDestinationOrderByFareAsc(model.getSource(), model.getDestination());
			
			case "departure":
				return flightRepository.findBySourceAndDestinationOrderByDepartureAsc(model.getSource(), model.getDestination());
				
			case "seats":
				return flightRepository.findBySourceAndDestinationOrderByAvailableSeatsDesc(model.getSource(), model.getDestination());

		}

		return optionalList;
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
	public String requestToAddFlight(FlightModel flightModel, Long userId) throws InvalidFlightDetailsException, SQLException
	{
		if(ObjectUtils.isEmpty(flightModel))
		{
			throw new InvalidFlightDetailsException("You Have Enter Wrong Flight Details ");
		}
		else
		{
			Flight flight = new Flight();
			flight = (Flight) ObjectUtility.mappingObjects(flightModel, flight);
			
			Optional<Flight> flightByNymberOptional = flightRepository.findByFlightNumber(flight.getFlightNumber());
			
			Flight flightByNumber = (Flight) ObjectUtility.checkOptional(flightByNymberOptional);
			
			if(ObjectUtils.isEmpty(flightByNumber))
			{
				flight.setStatus("pending");
				flightRepository.save(flight);
				return "Waiting for Super Admin Approval..........."; 
			}
			else
			{
				if(flightByNumber.getSource().equals(flight.getSource()) && flightByNumber.getDestination().equals(flight.getDestination()) && flightByNumber.getArrival().equals(flight.getArrival()) && flightByNumber.getDeparture().equals(flight.getDeparture()))
					throw new InvalidFlightDetailsException("The Flight Already available for "+flight.getSource()+" -> "+flight.getDestination()+" "+flight.getDeparture()+" To "+flight.getArrival());
				else
				{
					flight.setStatus("pending");
					flightRepository.save(flight);
					return "Waiting for Super Admin Approval...........";
				}
					
			}
		}

	}
}





