package com.booking.flight.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name= "passerner")
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
	
	@Column(name="booking_id", nullable = false)
	private Long bookingId;
	
	@ManyToOne
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

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Passenger(Long passengerId, String passengerName, Integer passengerAge, String passengerGender,
			Long bookingId) {
		super();
		this.passengerId = passengerId;
		PassengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerGender = passengerGender;
		this.bookingId = bookingId;
	}

	public Passenger() {
		super();
	}
	
	

}