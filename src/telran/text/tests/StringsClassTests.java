package telran.text.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.text.Strings.*;

class StringsClassTests {
	@Test
	void matchesTest() {
		assertEquals("match", matches("David", "david"));
		assertEquals("match", matches("John F", "John Fitzgerald"));
		assertEquals("match", matches("John Fit", "John F"));
		assertEquals("no match", matches("John K", "John Fitzgerald"));
		assertEquals("match", matches("Anna Maria Magdalena", "Anna Magdalena"));
		assertEquals("match", matches("Anna Maria Magdalena", "Maria Magdalena"));
		assertEquals("no match", matches("Anna Maria Magdalena", "Anna Maria Roberta"));
		assertEquals("no match", matches("Anna Maria Magdalena", "Anna Magdalena Roberta"));
		assertEquals("no match", matches("Anna Maria Magdalena", "Anna Magdalena Maria"));
		assertEquals("no match", matches("Elena Magdalena", "Anna Magdalena"));
		assertEquals("match", matches("M M M", "M"));
	}
	@Test
	void sortStringsAsNumbersTest() {
		String[] ar = {"9", "250", "50", "123", "23", "9", "123", "50"};
		String[] expected = {"9", "9", "23", "50", "50", "123", "123", "250"};
		sortStringsAsNumbers(ar);
		assertArrayEquals(expected, ar);
	}
}
