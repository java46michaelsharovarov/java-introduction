package telran.numbers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.numbers.MatrixInt.*;

class MatrixIntTest {
	@Test
	void testMatrixSum() {
		int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		assertEquals(45, matrixSum(matrix));
	}
	@Test
	void testInsertRow() {
		int matrix[][] = {{1, 2}, {3, 4}};
		int row1[] = {5, 6};
		int row2[] = {5};
		int row3[] = {5, 6, 7};
		int expected1[][] = {{1, 2}, {5, 6}, {3, 4}};
		int expected2[][] = {{1, 2}, {3, 4}, {5, 0}};
		int expected3[][] = {{5, 6}, {1, 2}, {3, 4}};
		assertArrayEquals(expected1, insertRow(matrix, row1, 1));
		assertArrayEquals(expected2, insertRow(matrix, row2, 2));
		assertArrayEquals(expected3, insertRow(matrix, row3, 0));
	}
	@Test
	void testInsertCollumn() {
		int matrix[][] = {{1, 2}, {3, 4}};
		int column1[] = {5, 6};
		int column2[] = {5};
		int column3[] = {5, 6, 7};
		int expected1[][] = {{1, 5, 2}, {3, 6, 4}};
		int expected2[][] = {{1, 2, 5}, {3, 4, 0}};
		int expected3[][] = {{5, 1, 2}, {6, 3, 4}};
		assertArrayEquals(expected1, insertColumn(matrix, column1, 1));
		assertArrayEquals(expected2, insertColumn(matrix, column2, 2));	
		assertArrayEquals(expected3, insertColumn(matrix, column3, 0));	
	}
	@Test
	void testRemoveRow() {
		int matrix1[][] = {{1, 2}, {5, 6}, {3, 4}};
		int matrix2[][] = {{1, 2}, {3, 4}, {5, 0}};
		int matrix3[][] = {{5, 6}, {1, 2}, {3, 4}};
		int expected[][] = {{1, 2}, {3, 4}};
		assertArrayEquals(expected, removeRow(matrix1, 1));
		assertArrayEquals(expected, removeRow(matrix2, 2));	
		assertArrayEquals(expected, removeRow(matrix3, 0));	
	}
	@Test
	void testRemoveCollumn() {
		int matrix1[][] = {{1, 5, 2}, {3, 6, 4}};
		int matrix2[][] = {{1, 2, 5}, {3, 4, 0}};
		int matrix3[][] = {{5, 1, 2}, {6, 3, 4}};
		int expected[][] = {{1, 2}, {3, 4}};
		assertArrayEquals(expected, removeColumn(matrix1, 1));
		assertArrayEquals(expected, removeColumn(matrix2, 2));	
		assertArrayEquals(expected, removeColumn(matrix3, 0));
	}
	@Test
	void testTransposition() {
		int matrix[][] = {{1, 2, 3}, {4, 5, 6}};
		int expected[][] = {{1, 4}, {2, 5}, {3, 6}};
		assertArrayEquals(expected, transposition(matrix));
	}
}
