package com.java8.learning.functionalinterface;

import java.util.function.Consumer;

public class _Consumer {

	public static void main(String[] args) {
		Customer customer = new Customer("Tom", "9999999999");
		greetCustomer(customer);
		// Java8
		greetCustomerConsumer.accept(customer);
	}

	// Normal
	static void greetCustomer(Customer customer) {
		System.out.println("Hello " + customer.name + ",thanks for registering mobile no " + customer.mobileNo);
	}

	// A consumer takes one argument and returns nothing
	static Consumer<Customer> greetCustomerConsumer = customer -> System.out
			.println("Hello " + customer.name + ",thanks for registering mobile no " + customer.mobileNo);

	static class Customer {
		private final String name;
		private final String mobileNo;

		Customer(String name, String mobileNo) {
			this.name = name;
			this.mobileNo = mobileNo;
		}

		@Override
		public String toString() {
			return "Customer [name=" + name + ", mobileNo=" + mobileNo + "]";
		}

	}

}
