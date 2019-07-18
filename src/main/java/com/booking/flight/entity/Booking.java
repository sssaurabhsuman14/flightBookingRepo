package com.booking.flight.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOKING_ID", nullable = false)
	private Long bookingId;

	@Column(name = "BOOKING_NUMBER", nullable = false)
	private Integer bookingNumber;

	@Column(name = "FLIGHT_ID", nullable = false)
	private Long flightId;

	@Column(name = "USER_ID", nullable = false)
	private Long userId;

	@Column(name = "BOOKING_DATE", nullable = false)
	private LocalDate bookingDate;

	@Column(name = "SEAT_BOOKED", nullable = false)
	private Integer seatBooked;

	@Column(name = "TOTAL_FARE", nullable = false)
	private Double totalFare;
	
	@OneToMany(mappedBy = "booking")
	List<Passenger> passengers;

	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
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
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Integer getSeatBooked() {
		return seatBooked;
	}
	public void setSeatBooked(Integer seatBooked) {
		this.seatBooked = seatBooked;
	}
	public Double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}
	
	
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	public Booking(Long bookingId, Integer bookingNumber, Long flightId, Long userId, LocalDate bookingDate,
			Integer seatBooked, Double totalFare) {
		super();
		this.bookingId = bookingId;
		this.bookingNumber = bookingNumber;
		this.flightId = flightId;
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.seatBooked = seatBooked;
		this.totalFare = totalFare;
	}

	public Booking() {

	}

}
