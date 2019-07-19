package com.booking.flight.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.flight.entity.Booking;
import com.booking.flight.entity.User;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	
	public List<Booking> findByUser(User user);

}
