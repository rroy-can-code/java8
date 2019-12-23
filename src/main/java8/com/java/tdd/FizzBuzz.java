package com.java.tdd;

public class FizzBuzz {

	public String play(int no) {
		if (no%3== 0)
			return "Fizz";
		else if (no%5== 0)
			return "Buzz";
			
		return String.valueOf(no);

		
	}

}
