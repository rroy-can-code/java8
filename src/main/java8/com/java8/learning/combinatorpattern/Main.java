package com.java8.learning.combinatorpattern;

import java.time.LocalDate;
import static com.java8.learning.combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

	public static void main(String[] args) {
		Customer customer = new Customer("Alice", "alicegmail.com", "+91999999", LocalDate.of(2000, 1, 1));
		System.out.println(new CustomerValidatorService().isValid(customer));
		ValidationResult result = isEmailValid().and(isMobileNoValid()).and(isAdult()).apply(customer);
		System.out.println(""+result);
	}
}
