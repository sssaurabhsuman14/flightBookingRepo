package com.booking.fight.model;

public class FlightModel {

	private Integer flightNumber;
	private String source;
	private String destination;
	private String departure;
	private String arrival;
	private Integer totalSeats;
	private Integer availableSeats;
	private Integer fare;
	private String flightSortBy;
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
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
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
	public Integer getFare() {
		return fare;
	}
	public void setFare(Integer fare) {
		this.fare = fare;
	}
	public String getFlightSortBy() {
		return flightSortBy;
	}
	public void setFlightSortBy(String flightSortBy) {
		this.flightSortBy = flightSortBy;
	}
	public FlightModel(Integer flightNumber, String source, String destination, String departure, String arrival,
			Integer totalSeats, Integer availableSeats, Integer fare, String flightSortBy) {
		super();
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.fare = fare;
		this.flightSortBy = flightSortBy;
	}


	public FlightModel() {

	}
}