package com.booking.flight.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.booking.flight.entity.Booking;
import com.booking.flight.entity.User;
import com.booking.flight.repository.BookingRepository;
import com.booking.flight.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookingRepository bookingRepository;
	
	public List<Booking> loginUser(String userName, String password) throws Exception{
		
		User loginUser = userRepository.findByUserNameAndUserPassword(userName, password);
		
		if(loginUser!= null) {
			return bookingRepository.findByUserId(loginUser.getUserId());
		}else {
			throw new Exception("No user found !!!");
		}
		
	}

}
