package com.java.tdd.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.java.tdd.FizzBuzz;
/**
 * 
 * @author Rahul
 * 
 * Game FizzBuzz
 * if no is divisable by 3 Fizz
 * if no is divisable by 5 Buzz
 * else tell the no
 *
 */
public class FizzBuzzTest {
	FizzBuzz fb;

	@Before
	public void init() {
		fb = new FizzBuzz();
	}

	@Test
	public void testNumber() {
		int no = 1;
		String s = fb.play(no);
		Assert.assertEquals("1", s);

	}
	
	@Test
	public void testFizz() {
		int no = 3;
		String s = fb.play(no);
		Assert.assertEquals("Fizz", s);

	}
	@Test
	public void testFizzDivideby3() {
		int no = 6;
		String s = fb.play(no);
		Assert.assertEquals("Fizz", s);

	}
	@Test
	public void testBuzz() {
		int no = 5;
		String s = fb.play(no);
		Assert.assertEquals("Buzz", s);

	}
	

}
