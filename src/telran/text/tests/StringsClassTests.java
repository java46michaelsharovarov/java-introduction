package telran.text.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.text.Strings.*;

class StringsClassTests {
	private static final int N_RUNS = 10000;
	private static final int N_STRINGS = 1;
	@Test
	void joinTest() {
		String array[] = {"Hello", "Vasya"};
		String expected = "Hello Vasya";
		assertEquals(expected, join(array, " "));
	}
	@Test
	void splitTest() {
		String str = "Hello Vasya";
		String expected[] = {"Hello", "Vasya"};
		assertArrayEquals(expected, str.split(" "));
	}
	@Test
	void joinPerformanceTest() {
		String array[] = getBigArray();
		for(int i = 0; i < N_RUNS; i++) {
			join(array, " ");
		}
	}
	private String[] getBigArray() {
		String res[] = new String[N_STRINGS];
		for (int i = 0; i < res.length; i++) {
			res[i] = "Hello";
		}
		return res;
	}
	@Test
	void matchesTest() {
		assertEquals("match", matches("David", "david"));
		assertEquals("match", matches("John F", "John Fitzgerald"));
		assertEquals("no match", matches("John K", "John Fitzgerald"));
		assertEquals("match", matches("Anna Maria Magdalena", "Anna Magdalena"));
		assertEquals("match", matches("Anna Maria Magdalena", "Maria Magdalena"));
		assertEquals("no match", matches("Anna Maria Magdalena", "Anna Maria Roberta"));
		assertEquals("no match", matches("Anna Maria Magdalena", "Anna Magdalena Roberta"));
		assertEquals("no match", matches("Anna Maria Magdalena", "Anna Magdalena Maria"));
	}
	@Test
	void sortStringsAsNumbersTest() {
		String[] ar = {"9", "250", "50", "123", "23", "9", "123", "50"};
		String[] expected = {"9", "9", "23", "50", "50", "123", "123", "250"};
		assertArrayEquals(expected, sortStringsAsNumbers(ar));
	}
}
