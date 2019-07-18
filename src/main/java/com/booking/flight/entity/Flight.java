package com.booking.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FLIGHT")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FLIGHT_ID", nullable=false)
	private Long flightId;

	@Column(name = "FLIGHT_NUMBER", nullable=false)
	private Integer flightNumber;

	@Column(name = "SOURCE", nullable=false)
	private String source;

	@Column(name = "DESTINATION", nullable=false)
	private String destination;

	@Column(name = "DEPARTURE", nullable=false)
	private String departure;

	@Column(name = "ARRIVAL", nullable=false)
	private String arrival;

	@Column(name = "TOTAL_SEATS", nullable=false)
	private Integer totalSeats;

	@Column(name = "AVAILABLE_SEATS", nullable=false)
	private Integer availableSeats;

	@Column(name = "FARE", nullable=false)
	private Double fare;

	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
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
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}

	public Flight(Long flightId, Integer flightNumber, String source, String destination, String departure,
			String arrival, Integer totalSeats, Integer availableSeats, Double fare) {
		super();
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.fare = fare;
	}

	public Flight() {

	}
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightNumber=" + flightNumber + ", source=" + source
				+ ", destination=" + destination + ", departure=" + departure + ", arrival=" + arrival + ", totalSeats="
				+ totalSeats + ", availableSeats=" + availableSeats + ", fare=" + fare + "]";
	}

}