import java.util.Scanner;

public class MatrixChecker {
	public static boolean equals(int[][] m1, int[][] m2) {
		if (m1.length != m2.length) {
			// Matrices have unequal number of rows
			return false;
		}

		if (m1.length == 0) {
			// Both matrices are empty, and therefore equal
			return true;
		}

		if (m1[0].length != m2[0].length) {
			// Matrices have unequal number of columns
			return false;
		}

		int length = m1.length;

		for (int row = 0; row < length; row++) {
			for (int col = 0; col < length; col++) {
				if (m1[row][col] != m2[row][col]) {
					// One element is different
					return false;
				}
			}
		}

		return true;
	}

	public static void fillMatrix(int[][] matrix, int[] values) {
		int length = matrix.length;

		for (int row = 0; row < length; row++) {
			for (int col = 0; col < length; col++) {
				int flatIndex = length * row + col; // Matrix index mapped to flat list index. (e.g., 0-8 for 3x3)
				matrix[row][col] = values[flatIndex];
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[][] matrix1 = new int[3][3];
		int[] matrixInputs1 = new int[9];

		int[][] matrix2 = new int[3][3];
		int[] matrixInputs2 = new int[9];

		boolean inputInvalid = true;

		do {
			System.out.println("Enter 9 numbers for your first 3x3 matrix:");
			String input = scanner.nextLine();

			String[] inputValues = input.split(" ");

			if (inputValues.length < 9) {
				System.out.println("\nYou did not enter enough values for a 3x3 matrix.\n");
				continue;
			} 
			
			if (inputValues.length > 9) {
				System.out.println("\nYou entered too many values for a 3x3 matrix.\n");
				continue;
			}

			boolean nonNumericValue = false;
			
			for(int i = 0; i < 9; i++) {
				try {
					int number = Integer.parseInt(inputValues[i]);
					matrixInputs1[i] = number;
				} catch (NumberFormatException ex) {
					System.out.println("\nYou entered a non-numeric value.\n");
					nonNumericValue = true;
				}
			}

			if (nonNumericValue) {
				continue;
			}

 			inputInvalid = false;

		} while (inputInvalid);

		fillMatrix(matrix1, matrixInputs1);

		inputInvalid = true;

		do {
			System.out.println("Enter 9 numbers for your second 3x3 matrix:");
			String input = scanner.nextLine();

			String[] inputValues = input.split(" ");

			if (inputValues.length < 9) {
				System.out.println("\nYou did not enter enough values for a 3x3 matrix.\n");
				continue;
			} 
			
			if (inputValues.length > 9) {
				System.out.println("\nYou entered too many values for a 3x3 matrix.\n");
				continue;
			} 
			
			boolean nonNumericValue = false;
			
			for(int i = 0; i < 9; i++) {
				try {
					int number = Integer.parseInt(inputValues[i]);
					matrixInputs2[i] = number;
				} catch (NumberFormatException ex) {
					System.out.println("\nYou entered a non-numeric value.\n");
					nonNumericValue = true;
				}
			}

			if (nonNumericValue) {
				continue;
			}

			inputInvalid = false;

		} while (inputInvalid);

		fillMatrix(matrix2, matrixInputs2);

		scanner.close();

		boolean matricesAreEqual = equals(matrix1, matrix2);

		if (matricesAreEqual) {
			System.out.println("\nThe two matrices you entered are equal.");
		} else {
			System.out.println("\nThe two matrices you entered are NOT equal.");
		}
	}
}