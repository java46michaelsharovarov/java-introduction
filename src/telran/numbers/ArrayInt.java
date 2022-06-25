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
	public static void sort(int[] ar) {
		int length = ar.length;
		while(!moveMaxToEnd(ar, length)) {
			length--;
		}
	}
	private static boolean moveMaxToEnd(int[] ar, int length) {
		int count = 0;
		for(int i = 1; i < length; i++) {
			if(ar[i-1] > ar[i]) {
				swap(ar, i);
			} else {
				count++;
			}
		}
		return count == length - 1 ? true : false;
	}
	private static void swap(int[] ar, int i) {
		int tmp = ar[i - 1];
		ar[i - 1] = ar[i];
		ar[i] = tmp;
	}
	public static int binaryIndexOf(int[] ar, int number) {
		int left = 0;
		int right = ar.length - 1;
		int middle = ar.length / 2;
		int index = -1;
		int nExistIndex = 0;
		while(left <= right) {
			if(ar[middle] < number) {
				if(middle != right) { 
					if(ar[middle + 1] > number) {
						return -(middle + 1);
					}
					nExistIndex = ar.length;
				}
				left = middle + 1;
			} else if(ar[middle] > number){
				if(middle != left) {  
					if(ar[middle - 1] < number) {
						return -(middle + 1);
					}
					nExistIndex = 0;
				}
				right = middle - 1;
			} else {
				index =  middle;
				right = middle - 1;
			}
			middle = (left + right) / 2;
		}
		return index >= 0 ? index : -(nExistIndex+1);
		}
}

