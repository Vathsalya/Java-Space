
/**
 * nCr = n!/(r! * (n-r)!)
 * 
 * @author Vathsalya
 *
 */
public class PascalTriangle {

	public static void main(String[] args) {
		int limit = 8;
		for (int row = 0; row < limit; row++) {
			for (int position = 0; position <= row; position++) {
				System.out.print(calculateNCR(row, position) + " ");
			}
			System.out.println("\n");
		}
	}

	private static int calculateNCR(int row, int position) {
		int nFactorial = factorial(row);
		int rFactorial = factorial(position);
		int nMinusRFactorial = factorial(row - position);
		return nFactorial / (rFactorial * nMinusRFactorial);
	}

	private static int factorial(int n) {
		if ((n == 0) || (n == 1)) {
			return 1;
		}
		return n * factorial(n - 1);
	}
}
