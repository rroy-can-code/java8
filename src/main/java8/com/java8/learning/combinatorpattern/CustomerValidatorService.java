package com.java8.learning.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
//Normal way
public class CustomerValidatorService {
	public boolean isValidEmail(String email) {
		return email.contains("@");
	}

	public boolean isValidMobileNo(String mobileNo) {
		return mobileNo.contains("+91");
	}

	public boolean isAdult(LocalDate dob) {
		return Period.between(dob, LocalDate.now()).getYears() > 16;
	}
    public boolean isValid(Customer customer){
    	return isValidEmail(customer.getEmail()) && isValidMobileNo(customer.getMobileNo()) && isAdult(customer.getDob());
    }
}
