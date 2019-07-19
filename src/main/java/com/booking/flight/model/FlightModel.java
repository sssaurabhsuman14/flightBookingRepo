package com.booking.flight.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;


public class FlightModel {

	private Integer flightNumber;
	private String source;
	private String destination;
	private LocalTime departure;
	private LocalTime arrival;
	private Integer totalSeats;
	private Integer availableSeats;
	private Double fare;
	private String flightSortBy;
	private LocalDate flightDate;
	private String status;


	

	public FlightModel(Integer flightNumber, String source, String destination, LocalTime departure, LocalTime arrival,
			Integer totalSeats, Integer availableSeats, Double fare) {
		super();
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.fare = fare;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}
	public Integer getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalTime getDeparture() {
		return departure;
	}
	public void setDeparture(LocalTime departure) {
		this.departure = departure;
	}
	public LocalTime getArrival() {
		return arrival;
	}
	public void setArrival(LocalTime arrival) {
		this.arrival = arrival;
	}
	public Integer getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}
	public Integer getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getFlightSortBy() {
		return flightSortBy;
	}
	public void setFlightSortBy(String flightSortBy) {
		this.flightSortBy = flightSortBy;
	}

}