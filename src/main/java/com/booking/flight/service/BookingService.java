package com.booking.flight.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booking.flight.entity.User;
import com.booking.flight.model.PassengerModel;
import com.booking.flight.entity.Booking;
import com.booking.flight.entity.Flight;
import com.booking.flight.entity.Passenger;
import com.booking.flight.repository.BookingRepository;
import com.booking.flight.repository.FlightRepository;
import com.booking.flight.repository.PassengerRepository;
import com.booking.flight.repository.UserRepository;
import com.booking.flight.utils.FareUtils;
import com.booking.flight.validation.FlightNotAvailableException;
import com.booking.flight.validation.UserNotFoundException;
import com.booking.flight.validation.Validation;

@Service
public class BookingService 
{
	
	@Autowired BookingRepository bookingrepository;
	
	@Autowired PassengerRepository passengerrepository;
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Validation validation;
	
	@Autowired
	FareUtils fareUtils;
	
	public Booking doFlightBooking(Long userId, Long fligtId ,  List<PassengerModel> passengers) throws FlightNotAvailableException, UserNotFoundException
	{
		
		Flight flight = null;
		User user =  null;
		Booking booked = null;
		
		Optional<Flight> flightOptional  =  flightRepository.findById(fligtId);
		boolean isFlightByAvailableSeats = false;

		if(flightOptional.isPresent()) 
		{
			flight  = flightOptional.get();
			isFlightByAvailableSeats = validation.validateFlightByAvailableSeats(flight.getAvailableSeats(),passengers.size());
		}
		else
		{
			throw new FlightNotAvailableException(" Flight not available ");
		}
		
		Optional<User> userOptional  =  userRepository.findById(userId);
		
		if(userOptional.isPresent()) 
		{
			user  = userOptional.get();
		}
		else
		{
			throw new UserNotFoundException("You have enter wrong User Id");
		}
		
		if(isFlightByAvailableSeats)
		{
			List <Passenger> passengerList = mappingPassengerModelListToPassengerList(passengers);

			Double totalFare = fareUtils.calculateTotalFare(flight.getFare(),passengers.size());
			
			Booking booking = new Booking();
			booking.setBookingDate(LocalDate.now());
			booking.setBookingNumber((int) Math.abs(Math.random()*1000000));
			booking.setUser(user);
			booking.setFlight(flight);
			booking.setSeatBooked(passengers.size());
			booking.setTotalFare(totalFare);
			booking.setPassengers(passengerList);
			
			booked=bookingrepository.save(booking);
			
			//createPassenger(passengerList, booked);
		}
		else
		{
			throw new FlightNotAvailableException(" Seats not available ");
		}
		
		return booked;
		
		
		
	}

	private void createPassenger(List<Passenger> passengerList, Booking booking) {
		for(Passenger passenger:passengerList)
		{
			passenger.setBooking(booking);
			passengerrepository.save(passenger);
		}
			
		
	}

	private List<Passenger> mappingPassengerModelListToPassengerList(List<PassengerModel> passengers) 
	{
		List<Passenger> passangerList = new ArrayList<>();
		
		for(PassengerModel passModel: passengers)
		{
			Passenger pass = new Passenger();
			pass.setPassengerAge(passModel.getPassengerAge());
			pass.setPassengerGender(passModel.getPassengerGender());
			pass.setPassengerName(passModel.getPassengerName());
			
			passangerList.add(pass);
		}
		return passangerList;
		
	}

	
}
