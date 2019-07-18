package com.booking.flight.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.booking.flight.entity.User;
import com.booking.flight.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public String loginUser(String userName, String password) throws Exception{
		
		User loginUser = userRepository.findByUserNameAndUserPassword(userName, password);
		
		if(ObjectUtils.isEmpty(loginUser))
		{
			throw new Exception("Please enter the valid credential");
		}
		return "success";
		
	}

}
