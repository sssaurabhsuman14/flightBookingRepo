package com.booking.flight.model;

import java.util.Date;


public class BookingModel {

	private Integer bookingNumber;
	private Long flightId;
	private Long userId;
	private Date bookingDate;
	private String seatBooked;
	private Integer totalFare;
	public Integer getBookingNumber() {
		return bookingNumber;
	}
	public void setBookingNumber(Integer bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getSeatBooked() {
		return seatBooked;
	}
	public void setSeatBooked(String seatBooked) {
		this.seatBooked = seatBooked;
	}
	public Integer getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(Integer totalFare) {
		this.totalFare = totalFare;
	}
	public BookingModel(Integer bookingNumber, Long flightId, Long userId, Date bookingDate, String seatBooked,
			Integer totalFare) {
		super();
		this.bookingNumber = bookingNumber;
		this.flightId = flightId;
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.seatBooked = seatBooked;
		this.totalFare = totalFare;
	}
	public BookingModel() {
		super();
	}
	
	
}
