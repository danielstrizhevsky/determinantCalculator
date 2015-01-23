import java.util.Scanner;


public class DeterminantCalculator {
	public static void main(String[] args) {
		int matrixSize = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of rows/columns: ");
		matrixSize = scan.nextInt();
		double[][] matrix = new double[matrixSize][matrixSize];
		for (int i = 0; i < matrixSize; i++) {
			System.out.print("Enter values of row " + (i + 1) + " separated by spaces: ");
			for (int j = 0; j < matrixSize; j++) {
				matrix[i][j] = scan.nextDouble();
			}
		}
		scan.close();
		System.out.print("Determinant: " + determinant(matrix));
	}
	
	public static double determinant(double[][] matrix) {
		if (matrix.length == 1 && matrix[0].length == 1)
			return matrix[0][0];
		
		double determinant = 0;
		for (int i = 0; i < matrix.length; i++) {
			double[][] minor = new double[matrix.length - 1][matrix[i].length - 1];
			for (int j = 0; j < matrix.length - 1; j++) {
				for (int k = 0; k < matrix[j].length - 1; k++) {
					if (j < i) {
						minor[j][k] = matrix[j][k + 1];
					} else {
						minor[j][k] = matrix[j + 1][k + 1];
					}
				}
			}
			determinant += Math.pow(-1, i) * matrix[i][0] * determinant(minor);
		}
		return determinant;
	}
}
