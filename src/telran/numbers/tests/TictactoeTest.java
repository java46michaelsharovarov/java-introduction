package telran.numbers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.numbers.TictactoeGame.*;

class TictactoeTest {

	@Test
	void testTictactoeMove() {
		char matrix[][] = {{'X', '0', 'X'},
						   {'0', 'X', '0'},
						   {'0', '\0', '\0'}};
		assertEquals(0, tictactoeMove(matrix, 0, 1, '0'));
	}
	void testTictactoeMove1() {
		char matrix[][] = {{'X', '0', 'X'},
						   {'0', 'X', '0'},
						   {'0', '\0', '\0'}};
		assertEquals(1, tictactoeMove(matrix, 0, 1, 'X'));
	}
	void testTictactoeMove2() {
		char matrix[][] = {{'X', '0', 'X'},
						   {'0', 'X', '0'},
						   {'0', '0', '\0'}};
		assertEquals(1, tictactoeMove(matrix, 0, 1, 'X'));
	}
	void testTictactoeMove3() {
		char matrix[][] = {{'X', '0', 'X'},
						   {'0', 'X', '0'},
						   {'0', 'X', '\0'}};
		assertEquals(2, tictactoeMove(matrix, 0, 1, '0'));
	}

}
