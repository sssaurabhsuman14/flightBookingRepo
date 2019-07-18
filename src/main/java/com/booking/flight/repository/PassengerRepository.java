package com.booking.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.flight.entity.Passenger;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
