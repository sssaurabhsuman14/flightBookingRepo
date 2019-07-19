package com.booking.flight.utils;

import java.util.Optional;


public class OptionalUtils {

	public static Object checkOptional(Optional<?> optionalObject) {
		
		if(optionalObject.isPresent())
			return optionalObject.get();
		else
			return null;	
	}

}
