package com.booking.flight.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.flight.entity.Booking;
import com.booking.flight.model.PassengerModel;
import com.booking.flight.service.BookingService;
import com.booking.flight.service.FlightService;
import com.booking.flight.validation.FlightNotAvailableException;
import com.booking.flight.validation.UserNotFoundException;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	FlightService flightService;
	
	@Autowired
	BookingService bookingService;

	@PostMapping("/flightbooking")
	public ResponseEntity<?> doFlightBooking(@RequestParam(value="flightId") Long flightId, @RequestParam(value="userId") Long userId, @RequestBody List<PassengerModel> passengerList) throws Exception{

		Booking booking = new Booking(); 

			try {
				booking = bookingService.doFlightBooking(userId, flightId, passengerList);
			} 
			catch (FlightNotAvailableException | UserNotFoundException e) {
				return new ResponseEntity<>("Invalid Operation "+e.getMessage(),HttpStatus.BAD_REQUEST);
			}

		return new ResponseEntity<>(booking,HttpStatus.OK);
	}

}
