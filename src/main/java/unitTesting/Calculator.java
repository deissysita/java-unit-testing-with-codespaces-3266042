package unitTesting;

public class Calculator {

	public int sum(int x, int y) {
		return x+y;
	}

	public int subtract(int x, int y) {
		return x-y;
	}

	public int multiply(int x, int y) {
		return x*y;
	}

	public int divide(int x, int y) {
		if(y == 0) {
			throw new IllegalArgumentException("Ints cannot be divided by zero");
		}
 		return x/y;
	}

	public boolean isEven(int x) {
		return x % 2 == 0;
	}

	public int[] incrementArray(int[] array) {
		int[] incrementedArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			incrementedArray[i] = array[i] + 1;
		}
		return incrementedArray;
	}
}