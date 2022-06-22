package telran.numbers;

import static java.util.Arrays.*;
import static java.lang.System.*;

public class ArrayInt {
	public static int[] addNumber(int []ar, int number) {
		int res[] = copyOf(ar, ar.length + 1);
		res[res.length - 1] = number;
		return res;
	}
	public static int[] insertNumber(int []ar, int index, int number) {
		int res[] = new int[ar.length + 1];
		arraycopy(ar, 0, res, 0, index);
		res[index] = number;
		arraycopy(ar, index, res, index + 1, ar.length - index);		
		return res;
	}
	public static int[] removeNumber(int []ar, int index) {
		int res[] = new int[ar.length - 1];
		arraycopy(ar, 0, res, 0, index);
		arraycopy(ar, index + 1, res, index, res.length - index);		
		return res;
	}
	public static int indexOf(int []ar, int number) {
		int res = -1;
		for(int i = 0; i < ar.length; i++) {
			if(ar[i] == number) {
				res = i;
				break;
			}
		}
		return res;
	}
}
