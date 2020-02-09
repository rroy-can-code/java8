package com.java8.learning.combinatorpattern;

import java.time.LocalDate;

/**
 * @author Rahul
 *
 */
public class Customer {
	private final String name;
	private final String email;
	private final String mobileNo;
	private final LocalDate dob;

	public Customer(String name, String email, String mobileNo, LocalDate dob) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public LocalDate getDob() {
		return dob;
	}

}
