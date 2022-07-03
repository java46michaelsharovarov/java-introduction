package telran.numbers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.numbers.TictactoeGame.*;

class TictactoeTest {
	@Test
	void testTictactoeMoveColumn() {
		char matrix[][] = {{'X', '0', 'X'},
						   {'X', '0', '0'},
						   {' ', ' ', ' '}};
		assertEquals(1, tictactoeMove(matrix, 2, 0, 'X'));
	}
	@Test
	void testTictactoeMoveRow() {
		char matrix[][] = {{'X', '0', 'X'},
						   {'0', ' ', '0'},
						   {'X', 'X', ' '}};
		assertEquals(1, tictactoeMove(matrix, 1, 1, '0'));
	}
	@Test
	void testTictactoeDiagonalLeft() {
		char matrix[][] = {{'0', 'X', 'X'},
						   {'X', '0', '0'},
						   {'X', 'X', ' '}};
		assertEquals(1, tictactoeMove(matrix, 2, 2, '0'));
	}
	@Test
	void testTictactoeMoveDiagonalRight() {
		char matrix[][] = {{'0', '0', 'X'},
						   {'X', ' ', '0'},
						   {'X', 'X', ' '}};
		assertEquals(1, tictactoeMove(matrix, 1, 1, 'X'));
	}
	@Test
	void testTictactoeMoveDraw() {
		char matrix[][] = {{'0', '0', 'X'},
						   {'X', 'X', '0'},
						   {'0', 'X', ' '}};
		assertEquals(2, tictactoeMove(matrix, 2, 2, 'X'));
	}
	@Test
	void testTictactoeEmpty() {
		char matrix[][] = new char[3][3];
		assertEquals(0, tictactoeMove(matrix, 1, 2, 'X'));
	}

}
