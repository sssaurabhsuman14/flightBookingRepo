package com.booking.flight.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.flight.entity.Booking;
import com.booking.flight.entity.Flight;
import com.booking.flight.entity.Passenger;
import com.booking.flight.service.FlightService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	FlightService flightService;

	@PostMapping("/tickets")
	public ResponseEntity<?> doFlightBooking(@RequestParam(value="flightId") Long flightId, @RequestParam(value="userId") Long userId, @RequestBody List<Passenger> passengerList){

		Booking booking = new Booking();

		Optional<Flight> flight = flightService.getFlight(flightId);

		if(flight.get().getAvailableSeats()> passengerList.size()) {
			//call service method
		}

		return new ResponseEntity<>(booking,HttpStatus.OK);
	}

}
