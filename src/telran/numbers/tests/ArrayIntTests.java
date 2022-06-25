package telran.numbers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.numbers.ArrayInt;
import java.util.Arrays;

class ArrayIntTests {

	private static final int SMALL_N_NUMBERS = 100;
	private static final int LARGE_N_NUMBERS = 1_000_00;
	private static final int N_RUNS = 1000;
	
	@Test
	void reference() {
		int ar[] = {1, 2, 3, 4};
		int ar1[] = ar;
		ar1[1] = 100;
		assertEquals(100, ar[1]);
	}
	@Test
	void addNumber() {
		int expected[] = {1, 2, -10, 20};
		int ar[] = {1, 2, -10};
		assertArrayEquals(expected, ArrayInt.addNumber(ar, 20));
	}
	@Test
	void insertNumber() {
		int expected[] = {1, 2, -10, 20};
		int ar[] = {1, 2, 20};
		assertArrayEquals(expected, ArrayInt.insertNumber(ar, 2, -10));
	}
	@Test
	void removeNumber() {
		int expected1[] = {1, 20};
		int expected2[] = {2, 20};
		int expected3[] = {1, 2};
		int ar[] = {1, 2, 20};
		assertArrayEquals(expected1, ArrayInt.removeNumber(ar, 1));
		assertArrayEquals(expected2, ArrayInt.removeNumber(ar, 0));
		assertArrayEquals(expected3, ArrayInt.removeNumber(ar, 2));
	}
	@Test
	void indexOf() {
		int ar[] = {1, 2, 20, 2};
		assertEquals(1, ArrayInt.indexOf(ar, 2));
		assertEquals(0, ArrayInt.indexOf(ar, 1));
		assertEquals(-1, ArrayInt.indexOf(ar, 10));
	}
	@Test
	void sortSmall() {
		int ar[] = new int [SMALL_N_NUMBERS];
		fillRandomNumbers(ar);
		ArrayInt.sort(ar);
		runSortTest(ar);
	}
	@Test
	void sortLarge() {
		int ar[] = new int [LARGE_N_NUMBERS];
		fillRandomNumbers(ar);
		Arrays.sort(ar);
		ArrayInt.sort(ar);
		runSortTest(ar);
	}
	@Test
	void binarySearch() {
		int ar[] = {1, 5, 100, 200, 350, 500};
		assertEquals(0, ArrayInt.binaryIndexOf(ar, 1));
		assertEquals(2, ArrayInt.binaryIndexOf(ar, 100));
		assertEquals(5, ArrayInt.binaryIndexOf(ar, 500));
		assertTrue(ArrayInt.binaryIndexOf(ar, 150) < 0);
		assertEquals(-1, ArrayInt.binaryIndexOf(ar, -10));
		assertEquals(-4, ArrayInt.binaryIndexOf(ar, 150));
		assertEquals(-7, ArrayInt.binaryIndexOf(ar, 600));
		assertEquals(5, ArrayInt.binaryIndexOf(ar, 500));
		int ar1[] = {1, 1, 1, 1, 1};
		assertEquals(0, ArrayInt.binaryIndexOf(ar1, 1));
	}
	@Test
	void indexOfPerformance() {
		int ar[] = new int[LARGE_N_NUMBERS];
		for(int i = 0; i < N_RUNS; i++) {
			assertTrue(ArrayInt.indexOf(ar, 1) < 0);
		}
	}
	@Test
	void binaryIndexOfPerformance() {
		int ar[] = new int[LARGE_N_NUMBERS];
		int ar1[] = {0,2,4,6,8,10,12,15};
		for(int i = 0; i < N_RUNS; i++) {
			assertTrue(ArrayInt.binaryIndexOf(ar1, 1) < 0);
		}
	}
	private void runSortTest(int[] ar) {
		for(int i = 1; i < ar.length; i++) {
			assertTrue(ar[i-1] <= ar[i]);
		}
	}
	private void fillRandomNumbers(int[] ar) {
		for(int i = 0; i < ar.length; i++) {
			ar[i] = (int) (Math.random() * Integer.MAX_VALUE);
		}		
	}
}
