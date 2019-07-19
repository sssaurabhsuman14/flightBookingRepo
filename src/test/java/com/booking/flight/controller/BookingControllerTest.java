package com.booking.flight.controller;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.booking.flight.entity.Booking;
import com.booking.flight.entity.Flight;
import com.booking.flight.entity.User;
import com.booking.flight.model.PassengerModel;
import com.booking.flight.service.BookingService;
import com.booking.flight.validation.FlightNotAvailableException;
import com.booking.flight.validation.UserNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class BookingControllerTest {

	@InjectMocks
	BookingController bookingController;

	@Mock
	private BookingService bookingService;

	List<PassengerModel> passengers =  new ArrayList<PassengerModel>();
	Booking booking;

	@Before
	public void setUp() {
		LocalTime arrival = LocalTime.of(21, 30, 59, 11001);
		LocalTime departure = LocalTime.of(22, 30, 59, 11001);

		User user = new User(1l, "saurabh.suman", "123", 22, "male", "pune", "user");
		Flight flight = new Flight(1l, 1234, "pune", "mumbai", arrival, departure, 100, 50, 1000d);

		LocalDate bookingDate = LocalDate.of(2019, 06, 03);
		booking = new Booking(1L, 123, bookingDate, 1, 1000D, user, flight);
		PassengerModel passenger = new PassengerModel("amit", 22, "male");
		passengers.add(passenger);

	}

	@Test
	public void testDoFlightBookingWithSuccess() throws Exception {

		Mockito.when(bookingService.doFlightBooking(1l, 1l, passengers)).thenReturn(booking);
		assertNotNull(bookingController.doFlightBooking(1l, 1l, passengers));

	}

	
	@Test
	public void testDoFlightBookingWithFlightNotAvailableException() throws Exception {
		
		Mockito.when(bookingService.doFlightBooking(1l, 1l, passengers)).thenThrow(new FlightNotAvailableException());
		assertNotNull(bookingController.doFlightBooking(1l, 1l, passengers));
	}
	
	@Test
	public void testDoFlightBookingWithUserNotFoundException() throws Exception {
		
		Mockito.when(bookingService.doFlightBooking(1l, 1l, passengers)).thenThrow(new UserNotFoundException());
		assertNotNull(bookingController.doFlightBooking(1l, 1l, passengers));
	}

}
