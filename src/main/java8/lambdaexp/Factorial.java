package lambdaexp;

public class Factorial {

	public int getFactorial(int n) {
		return f.getVal(n);
	}

	FactFn f = no -> {
		if (no == 0)
			return 1;
		int fact = 1;
		for (int i = 1; i <= no; i++) {
			fact = i * fact;
		}
		return fact;
	};
}
