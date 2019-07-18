package com.booking.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.flight.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUserNameAndUserPassword(String userName, String password);

}
