package telran.text;

import java.util.Arrays;

public class Strings {
	public static int[] deepNoRepeatedCompare(String str1, String str2) {		
		int[] resArr = {0, 0};
		if (str1.length() <= 0 || str2.length() <= 0) {
			return resArr;
		}	
	/** The first implementation **/	
		int[] ar = new int[127];			
		for(int i = 0; i < ar.length; i++) {
			ar[i] = -1;
		}
		for(int i =0; i < str1.length(); i++) {
			ar[str1.charAt(i)] = i;
		}
		for(int index = 0; index < str2.length(); index++) {
			int indexCompar = ar[str2.charAt(index)];
			if(indexCompar >= 0) {
				if(indexCompar == index) {
					resArr[0] += 1;
				} else {
					resArr[1] += 1;
				}
			}
		}
	/** The second implementation **/
//		for(int index = 0; index < str1.length(); index++) {	
//			int indexCompar = str2.indexOf(str1.charAt(index));
//			if(indexCompar >= 0) {
//				if(indexCompar == index) {
//					resArr[0] += 1;
//				} else {
//					resArr[1] += 1;
//				}
//			}
//		}	
	/*******************************/	
		return resArr;		
	}
	
	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length() || str1.length() <= 0) {
			return false;
		}
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		int[] ar = new int[26];
		int[] arCompar = new int[26];
		for(int i = 0; i < str1.length(); i++) {
			ar[str1.charAt(i) - 97] += 1;
			arCompar[str2.charAt(i) - 97] += 1;
		}
		return Arrays.equals(ar, arCompar) ? true : false;		
	}
}
