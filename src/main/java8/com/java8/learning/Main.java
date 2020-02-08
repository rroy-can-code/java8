package com.java8.learning;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("John", Gender.MALE), new Person("Eli", Gender.FEMALE),
				new Person("Jimmi", Gender.MALE), new Person("Klein", Gender.FEMALE), new Person("Nick", Gender.MALE),
				new Person("Ana", Gender.FEMALE));

		// Declarative app
		final Predicate<Person> isFemale = person -> Gender.FEMALE.equals(person.gender);
		people.stream().filter(isFemale).forEach(System.out::println);

	}

}
