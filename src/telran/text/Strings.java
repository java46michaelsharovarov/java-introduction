package telran.text;

import java.util.Arrays;

public class Strings {
	/**
	 * 
	 * @param str1 ascii string with no repeated symbols
	 * @param str2 ascii string with no repeated symbols
	 * @return array with two numbers
	 *    first - number of the symbols of the str2 that exist in str1 at the same indexes
	 *    second - number of the symbols of the str2 that exist in str1 at different indexes
	 */
	public static int[] deepNoRepeatedCompare(String str1, String str2) {		
		int[] resArr = {0, 0};
		if (str1.isEmpty() || str2.isEmpty()) {
			return resArr;
		}	
		int[] ar = new int[127];			
	/** The first implementation O[N]**/			
//		lookupTableImplem(str1, str2, resArr, ar);
	/** The second implementation  O[N^2]**/
		indexOfImplem(str1, str2, resArr);	
		return resArr;		
	}
	private static void lookupTableImplem(String str1, String str2, int[] resArr, int[] ar) {
		initialLookupTable(ar);
		fillLookupTable(str1, ar);
		getResultCompare(str2, resArr, ar);
	}
	private static void initialLookupTable(int[] ar) {
		for(int i = 0; i < ar.length; i++) {
			ar[i] = -1;
		}
	}
	private static void fillLookupTable(String str1, int[] ar) {
		for(int i =0; i < str1.length(); i++) {
			ar[str1.charAt(i)] = i;
		}
	}
	private static void getResultCompare(String str2, int[] resArr, int[] ar) {
		for(int index = 0; index < str2.length(); index++) {
			int indexCompar = ar[str2.charAt(index)];
			if(indexCompar >= 0) {
				resArr[indexCompar == index ? 0 : 1]++;
			}
		}
	}
	private static void indexOfImplem(String str1, String str2, int[] resArr) {
		for(int index = 0; index < str1.length(); index++) {	
			int indexCompar = str2.indexOf(str1.charAt(index));
			if(indexCompar >= 0) {
				resArr[indexCompar == index ? 0 : 1]++;
			}
		}
	}
	/**
	 * 
	 * @param str1 English letters (may have repeats)
	 * @param str2 English letters (may have repeats)
	 * @return true if :
	 *     (1) str2 has the same as str1 length
	 *     (2) str2 comprises of all letters from str1
	 */
	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length() || str1.isEmpty()) {
			return false;
		}	
		int[] ar = new int[127];
	/** The first implementation arrays.equals (case insensitive)**/
//		int[] arCompar = new int[127];
//		fillLookupTablesOccurrences(str1, str2, ar, arCompar);
//		return Arrays.equals(ar, arCompar) ? true : false;
	
	/** The second implementation str.toCharArray with loop 'for'(case sensitive)**/
		fillHelperOccurrences(str1, ar);
		return getResultIsAnagram(str2, ar);		
	}
	private static void fillLookupTablesOccurrences(String str1, String str2, int[] ar, int[] arCompar) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		int str1Length = str1.length();
		for(int i = 0; i < str1Length; i++) {
			ar[str1.charAt(i)]++;
			arCompar[str2.charAt(i)]++;
		}
	}
	private static boolean getResultIsAnagram(String str, int[] helper) {
		char[] strAr = str.toCharArray();
		for(int i = 0; i < strAr.length; i++) {
			int count = helper[strAr[i]]--;
			if (count == 0) {
				return false;
			}
		}
		return true;
	}
	private static void fillHelperOccurrences(String str, int[] helper) {
		char[] strAr = str.toCharArray();
		for(int i = 0; i < strAr.length; i++) {
			helper[strAr[i]]++;
		}
	}
}
