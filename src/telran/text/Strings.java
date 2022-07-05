package telran.text;

public class Strings {	
	static public String join(String[] array, String delimiter) {
		//STring "+" operator based solution
//		return stringPluseSolution(array, delimiter);
		//StringBuilder attend based solution
		return stringBuilderSolution(array, delimiter);
	}
	static private String stringBuilderSolution(String[] array, String delimiter) {
		StringBuilder strBuilder = new StringBuilder(array[0]);
		for(int i = 1; i < array.length; i++) {
			strBuilder.append(delimiter).append(array[i]);
		}
		return strBuilder.toString();
	}
	static private String stringPluseSolution(String[] array, String delimiter) {
		String res = array[0]; //assumption: there is at least one string
		for(int i = 1; i < array.length; i++) {
			res += delimiter + array[i] ;
		}
		return res;
	}
	/**
	 * 
	 * @param name1 -  first name 
	 * @param name2 - second name
	 * @return either "match" or "no match" in accordance to the comments (see TODO)
	 */
	static public String matches(String name1, String name2) {
		String arName1[] = name1.split(" ");
		String arName2[] = name2.split(" ");
		if(arName1[arName1.length - 1].length() == 1 || arName1[arName1.length - 1].length() == 1) {
			if(Character.toLowerCase(arName1[arName1.length - 1].charAt(0))
					!= Character.toLowerCase(arName2[arName2.length - 1].charAt(0))) {
				return "no match";
			}
		}
		 else {
			 if (arName1[arName1.length - 1].compareToIgnoreCase(arName2[arName2.length - 1]) != 0){
					return "no match";
				}
		 }
		if(arName1.length == 1 && arName1.length == arName2.length) {
			return "match";
		}				
		return compareFirstName(arName1, arName2);
	}
	private static String compareFirstName(String[] arName1, String[] arName2) {
		for(int i = 0; i < arName1.length; i++) {
			for (int j = 0; j < arName2.length; j++) {
				if (arName1[i].compareToIgnoreCase(arName2[j]) == 0) {
					return "match";
				} 
			}
		}
		return "no match";
	}
	/**
	 * sorts array of strings
	 * @param strNumbers array of strings containing the positive integer numbers
	 * length of each string can not be more than three symbols
	 * String containing "123" should be greater than string containing "23" as the number 123 greater than
	 * number 23
	 */
	static public String[] sortStringsAsNumbers(String[] strNumbers) {
		int lookupTable[] = new int[1000];
		fillLookupTable(lookupTable, strNumbers);
		getResSortStrAsNum(lookupTable, strNumbers);
		return strNumbers;
	}
	private static void getResSortStrAsNum(int[] lookupTable, String[] strNumbers) {
		int currentIndex = 0;
		for(int i = 0; i < lookupTable.length; i++) {
			if(lookupTable[i] > 0) {
				for(int j = 0; j < lookupTable[i]; j++) {
					strNumbers[currentIndex++] = String.valueOf(i); 
				}
			}
		}		
	}
	private static void fillLookupTable(int[] lookupTable, String[] strNumbers) {
		for(int i = 0; i < strNumbers.length; i++) {
			 int index = Integer.valueOf(strNumbers[i]);
			 lookupTable[index]++;
		}		
	}
}
