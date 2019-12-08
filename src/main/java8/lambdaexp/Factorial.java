package lambdaexp;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		System.out.print("Enter the value :");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		FactFn f = no -> {
			int fact = 1;
			for (int i = 1; i <= no; i++) {
				fact = i * fact;
			}
			return fact;
		};
		System.out.println("Fact of n is " + f.getVal(n));
	}

}
