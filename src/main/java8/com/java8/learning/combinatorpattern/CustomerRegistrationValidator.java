package com.java8.learning.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {
	public static CustomerRegistrationValidator isEmailValid() {
		return customer -> customer.getEmail().contains("@") ? ValidationResult.SUCCESS
				: ValidationResult.INVALID_EMAIL;
	}

	public static CustomerRegistrationValidator isMobileNoValid() {
		return customer -> customer.getMobileNo().contains("+91") ? ValidationResult.SUCCESS
				: ValidationResult.INVALID_MOBILE_NO;
	}

	public static CustomerRegistrationValidator isAdult() {
		return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ? ValidationResult.SUCCESS
				: ValidationResult.NOT_AN_ADULT;
	}

	public default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
		return customer -> this.apply(customer).equals(ValidationResult.SUCCESS) ? other.apply(customer)
				: this.apply(customer);
	}
}

enum ValidationResult {
	SUCCESS, INVALID_EMAIL, INVALID_MOBILE_NO, NOT_AN_ADULT;
}