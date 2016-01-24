import java.util.Scanner;

/***
 * If an element in the R x C matrix is zero, its entire row and column is set
 * to zero
 * 
 * @author Dhaval
 *
 */
public class ZeroMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r, c;
		System.out.println("Enter R and C");
		r = sc.nextInt();
		c = sc.nextInt();

		int inputMatrix[][] = new int[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++) {
				System.out.print("\n a[" + i + "][" + j + "] = ");
				inputMatrix[i][j] = sc.nextInt();
			}

		System.out.println("Original Matrix : ");
		printMatrix(inputMatrix);

		int resultMatrix[][] = new int[r][c];
		resultMatrix = nullify(inputMatrix);

		System.out.println("Result Matrix : ");
		printMatrix(resultMatrix);
		sc.close();
	}

	/**
	 * Given a matrix, nullify the rows and columns containing 0
	 * 
	 * @param inputMatrix
	 * @return
	 */
	public static int[][] nullify(int inputMatrix[][]) {
		boolean nullRow[] = new boolean[inputMatrix.length];
		boolean nullColumn[] = new boolean[inputMatrix[0].length];

		// Record the rows and columns containing 0
		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix[0].length; j++) {
				if (inputMatrix[i][j] == 0) {
					nullRow[i] = true;
					nullColumn[j] = true;
				}
			}
		}

		// Set zeroes to the rows containing 0
		for (int i = 0; i < nullRow.length; i++) {
			if (nullRow[i]) {
				nullifyRow(inputMatrix, i);
			}
		}

		// Set zeroes to the columns containing 0
		for (int i = 0; i < nullColumn.length; i++) {
			if (nullColumn[i]) {
				nullifyColumn(inputMatrix, i);
			}
		}

		return inputMatrix;
	}

	/**
	 * Set zeroes to the specified row
	 * 
	 * @param inputMatrix
	 * @param c
	 * @return
	 */
	public static int[][] nullifyRow(int inputMatrix[][], int r) {
		for (int i = 0; i < inputMatrix[0].length; i++) {
			inputMatrix[r][i] = 0;
		}

		return inputMatrix;
	}

	/**
	 * Set zeroes to the specified column
	 * 
	 * @param inputMatrix
	 * @param c
	 * @return
	 */
	public static int[][] nullifyColumn(int inputMatrix[][], int c) {
		for (int i = 0; i < inputMatrix.length; i++) {
			inputMatrix[i][c] = 0;
		}

		return inputMatrix;
	}

	/**
	 * Utility to print the matrix
	 * 
	 * @param inputMatrix
	 */
	public static void printMatrix(int inputMatrix[][]) {
		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix[0].length; j++)
				System.out.print(inputMatrix[i][j] + "\t");
			System.out.println();
		}
	}

}