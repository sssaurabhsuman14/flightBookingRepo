package com.booking.flight.utils;

import org.springframework.stereotype.Component;

@Component
public class FareUtils {
	
	public Double calculateTotalFare(Double fare, Integer numberOfPassengers) {
		return (fare*numberOfPassengers);
	}

}
