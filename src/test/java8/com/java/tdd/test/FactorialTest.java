package com.java.tdd.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lambdaexp.Factorial;

public class FactorialTest {
	Factorial fact;

	@Before
	public void init() {
		fact = new Factorial();
	}

	@Test
	public void checkFactOfZero() {
		int fact0 = fact.getFactorial(0);
		Assert.assertEquals(1, fact0);
	}

	@Test
	public void checkFactOfFive() {
		int fact0 = fact.getFactorial(5);
		Assert.assertEquals(120, fact0);
	}
}