package com.booking.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable=false)
	private Long userId;

	@Column(name = "user_name", nullable=false)
	private String userName;

	@Column(name = "user_password", nullable=false)
	private String userPassword;

	@Column(name = "user_age", nullable=false)
	private Integer userAge;

	@Column(name = "user_gender", nullable=false)
	private String userGender;

	@Column(name = "user_adderss", nullable=false)
	private String userAddress;

	@Column(name = "role", nullable=false)
	private String role;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User(Long userId, String userName, String userPassword, Integer userAge, String userGender,
			String userAddress, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userAge = userAge;
		this.userGender = userGender;
		this.userAddress = userAddress;
		this.role = role;
	}

	public User() {
		super();
	}
}
