package com.booking.flight.model;


public class PassengerModel {
	

	private String passengerName;
	private Integer passengerAge;
	private String passengerGender;

	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public Integer getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public PassengerModel(String passengerName, Integer passengerAge, String passengerGender) {
		super();
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerGender = passengerGender;

	}
	public PassengerModel() {
		super();
	}
	
	
	
}
