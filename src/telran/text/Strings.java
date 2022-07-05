package telran.text;

public class Strings {	
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
