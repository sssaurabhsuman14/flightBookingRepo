package com.booking.flight.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.flight.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{

	public Optional<List<Flight>>findBySourceAndDestination(String source,String destinaton);
	
}
