package com.booking.flight.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.flight.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{

	public Optional<List<Flight>>findBySourceAndDestination(String source,String destinaton);

	public List<Flight> findByOrderByFareAsc();
	

	public Optional<List<Flight>> findBySourceAndDestinationOrderByFareAsc(String source, String destination);
	
	public Optional<List<Flight>> findBySourceAndDestinationOrderByDepartureAsc(String source, String destination);
	
	public Optional<List<Flight>> findBySourceAndDestinationOrderByAvailableSeatsDesc(String source, String destination);

	
	public Optional<List<Flight>> findBySource(String source);
	
	public Optional<Flight> findByFlightNumber(Integer flightNumber);
	
	
}
