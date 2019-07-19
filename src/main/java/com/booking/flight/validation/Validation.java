package com.booking.flight.validation;

import java.time.LocalDate;
import java.util.Optional;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.booking.flight.entity.Flight;
import com.booking.flight.entity.User;
import com.booking.flight.model.FlightModel;
import com.booking.flight.repository.FlightRepository;
import com.booking.flight.service.UserService;
import com.booking.flight.utils.OptionalUtils;

@Component
public class Validation {
	
	@Autowired
	UserService userService;

	private final static String ERR_MSG = " INVALID DATA, MISSING PARAMETER : ";

	public boolean validateFlightByAvailableSeats(Integer availableSeats , Integer requestedSeats) {

		if(availableSeats !=  null && requestedSeats != null && availableSeats >= requestedSeats) {
			return true;
		}
		return false;
	}


	public boolean validateUser(String userName , String password) {

		if(userName != null && password != null) {
			return true;
		}

		return false;
	}

	public boolean validateUserRole(Long userId) throws UserNotFoundException {
		
		Optional<User> userOptional = userService.getUserFromRepo(userId);
		User user = (User) OptionalUtils.checkOptional(userOptional);
		
		if(ObjectUtils.isEmpty(user)) 
		{
			throw new UserNotFoundException("User entry is not found.....");
		}
		else
		{
			if (user.getRole().equals("Admin")) 
				return true;
		}
		return false;
	}

	public void validateAddFlightDetails(Flight flight) throws InvalidFlightDetailsException {

		if (StringUtils.isEmpty(flight.getSource())) {
			throw new InvalidFlightDetailsException(ERR_MSG+" SOURCE");
		}
		if (StringUtils.isEmpty(flight.getDestination())) {
			throw new InvalidFlightDetailsException(ERR_MSG+" DESTINATION");

		}

		if (StringUtils.isEmpty(flight.getAvailableSeats().toString())) {
			throw new InvalidFlightDetailsException(ERR_MSG+" AVAILABLE SEATS");

		}

		if (StringUtils.isEmpty(flight.getArrival().toString())) {
			throw new InvalidFlightDetailsException(ERR_MSG+" ARRIVAL");

		}

		if (StringUtils.isEmpty(flight.getDeparture().toString())) {
			throw new InvalidFlightDetailsException(ERR_MSG+" DEPARTURE");

		}

		if (StringUtils.isEmpty(flight.getFare().toString())) {
			throw new InvalidFlightDetailsException(ERR_MSG+" FARE");

		}

		if (StringUtils.isEmpty(flight.getFlightId().toString())) {
			throw new InvalidFlightDetailsException(ERR_MSG+" FLIGHT ID");

		}

		if (StringUtils.isEmpty(flight.getFlightNumber().toString())) {
			throw new InvalidFlightDetailsException(ERR_MSG+" FLIGHT NUMBER");

		}

		if (StringUtils.isEmpty(flight.getTotalSeats().toString())) {
			throw new InvalidFlightDetailsException(ERR_MSG+" TOTAL SEATS");
		}
	}
	
	public void validateFlightDetails(FlightModel flightModel) throws InvalidFlightDetailsException
	{
		if(StringUtils.isEmpty(flightModel.getSource()))
			throw new InvalidFlightDetailsException(ERR_MSG+" SOURCE");

		if(StringUtils.isEmpty(flightModel.getDestination()))
			throw new InvalidFlightDetailsException(ERR_MSG+" DESTINATION");

		if(StringUtils.isEmpty(flightModel.getFlightDate().toString()))
			throw new InvalidFlightDetailsException(ERR_MSG+" Flight Date");

		if(flightModel.getFlightDate().isBefore(LocalDate.now()))
			throw new InvalidFlightDetailsException(" You have enter Invalid Flight Date");
	}
}
