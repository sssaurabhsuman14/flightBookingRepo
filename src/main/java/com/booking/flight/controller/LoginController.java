package com.booking.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.flight.service.UserService;
import com.booking.flight.validation.Validation;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	Validation validation;

	@GetMapping("/user")
	public ResponseEntity<?> validateUser(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) throws Exception {
		try {
			if (validation.validateUser(userName, password)) {
				userService.loginUser(userName, password);
			} else {
				return new ResponseEntity<String>("username/password cannot be empty", HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("Invalid Credential : " + e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<String>("Success", HttpStatus.OK);

	}

}
