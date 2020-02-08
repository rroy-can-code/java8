package com.java8.learning.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
	public static void main(String... strings) {
		// int inc=inc(1);
		int addOneAndMulBy10 = incByOne.andThen(mulBy10).apply(1);
		System.out.println("Using Function="+addOneAndMulBy10);
		System.out.println("Using BiFunction="+incrAndMultiply.apply(2, 10));
	}
	// Normal approach
	/*
	 * static int inc(int no){ return no+1; }
	 */
	// Java 8 Function

	static Function<Integer, Integer> incByOne = no -> no + 1;
	static Function<Integer, Integer> mulBy10 = no -> no * 10;

	// Java 8 BiFunction approach
	// Will take 2 args ans produces a result

	static BiFunction<Integer, Integer, Integer> incrAndMultiply = (noToInc, noToMult) -> (noToInc + 1) * noToMult;
}
