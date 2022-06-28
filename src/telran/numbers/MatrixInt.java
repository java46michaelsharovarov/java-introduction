package telran.numbers;

import static java.util.Arrays.*;
import static java.lang.System.*;

public class MatrixInt {
	public static int matrixSum(int matrix[][]) {
		int sum = 0; 
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				sum += matrix[i][j]; 
			}
		}
		return sum;
	}
	/**
	 * 
	 * @param matrix
	 * @param row
	 * @param index
	 * @return new matrix with inserted row at the given index
	 * @assumptions: the given matrix exist with at least one row
	 */
	public static int [][] insertRow(int matrix[][], int row[], int index) {
		int resMatrix[][] = new int[matrix.length + 1][];
		if(row.length != matrix[0].length) {
			row = copyOf(row, matrix[0].length);
		}
		arraycopy(matrix, 0, resMatrix, 0, index);
		resMatrix[index] = row;
		arraycopy(matrix, index, resMatrix, index + 1, matrix.length - index);
		return resMatrix;
	}
	public static int [][] insertColumn(int matrix[][], int column[], int index) {
		int resMatrix[][] = copyOf(matrix, matrix.length);
		if(column.length != matrix.length) {
			column = copyOf(column, matrix.length);
		}		
		for(int i = 0; i < resMatrix.length; i++) {
			resMatrix[i] = ArrayInt.insertNumber(resMatrix[i], index, column[i]);
		}
		return resMatrix;
	}
	public static int [][] removeRow(int matrix[][], int index) {
		int resMatrix[][] = new int[matrix.length - 1][];
		arraycopy(matrix, 0, resMatrix, 0, index);
		arraycopy(matrix, index + 1, resMatrix, index, resMatrix.length - index);		
		return resMatrix;
	}
	public static int [][] removeColumn(int matrix[][], int index) {
		int resMatrix[][] = copyOf(matrix, matrix.length);
		for(int i = 0; i < resMatrix.length; i++) {
			resMatrix[i] = ArrayInt.removeNumber(resMatrix[i], index);
		}
		return resMatrix;
	}
	public static int [][] transposition(int matrix[][]) {
		int resMatrix[][] = new int[matrix[0].length][matrix.length];
		for(int i = 0; i < resMatrix.length; i++) {
			for(int j = 0; j < resMatrix[i].length; j++) {
				resMatrix[i][j] = matrix[j][i];
			}
		}
		return resMatrix;
	}
}
