package com.booking.flight.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.flight.entity.Booking;
import com.booking.flight.entity.Flight;
import com.booking.flight.entity.Passenger;
import com.booking.flight.repository.BookingRepository;
import com.booking.flight.repository.FlightRepository;
import com.booking.flight.repository.PassengerRepository;
import com.booking.flight.utils.FareUtils;
import com.booking.flight.validation.FlightNotAvailableException;
import com.booking.flight.validation.Validation;

@Service
public class BookingService 
{
	
	@Autowired BookingRepository bookingrepository;
	
	@Autowired PassengerRepository passengerrepository;
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	Validation validation;
	
	@Autowired
	FareUtils fareUtils;
	
	public Booking doFlightBooking(Long userId, Long fligtId ,  List<Passenger> passengers)
	{
		
		Flight flight = null;
		Optional<Flight> flightOptional  =  flightRepository.findById(fligtId);
		

		boolean isFlightByAvailableSeats = false;
		
		if(flightOptional.isPresent()) 
		{
			flight  = flightOptional.get();
			isFlightByAvailableSeats = validation.validateFlightByAvailableSeats(flight.getAvailableSeats(),passengers.size());
		}
		
		
		Booking booked = new Booking();
		if(isFlightByAvailableSeats)
		{
			Double totalFare = fareUtils.calculateTotalFare(flight.getFare(),passengers.size());
			
			Booking booking = new Booking();
			booking.setBookingDate(LocalDate.now());
			booking.setBookingNumber((int) Math.abs(Math.random()*1000000));
			booking.setFlightId(fligtId);
			booking.setUserId(userId);
			booking.setSeatBooked(passengers.size());
			booking.setTotalFare(totalFare);
			
			booked=bookingrepository.save(booking);
			// TODO: Need to save passenger entity
			
			/*if(null !=booked)
			{
					Passenger passenger=new Passenger();
					
					passenger.setBookingId(booked.getBookingId());
					passenger.setPassengerAge(passengerAge);
					passenger.setPassengerGender(passengerGender);
					passenger.setPassengerId(passengerId);
					passenger.setPassengerName(passengerName);
					
			}
			
		
			*/
			
			
			
			
		}
		return booked;
		
		
		
	}

	
}
