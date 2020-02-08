package com.java8.learning;

public class Person {

	final String name;
	final Gender gender;

	public Person(String name, Gender gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + "]";
	}

}

enum Gender {
	MALE, FEMALE;
}
