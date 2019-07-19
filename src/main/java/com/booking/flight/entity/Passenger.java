package com.booking.flight.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name= "passenger")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "passengerId")
public class Passenger {
	
	@Id
	@Column(name="passenger_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long passengerId;
	
	@Column(name="passenger_name", nullable = false)
	private String PassengerName;

	@Column(name="passenger_age", nullable = false)
	private Integer passengerAge;
	
	@Column(name="passenger_gender", nullable = false)
	private String passengerGender;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
	Booking booking;

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return PassengerName;
	}

	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
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


	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	

	public Passenger(Long passengerId, String passengerName, Integer passengerAge, String passengerGender,
			Booking booking) {
		super();
		this.passengerId = passengerId;
		PassengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerGender = passengerGender;
		this.booking = booking;
	}

	public Passenger() {
		super();
	}
	
	

}