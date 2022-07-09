package telran.text;

import static telran.text.RegularExpressions.*;
public class Strings {	
//	static public String matches(String name1, String name2) {
//		String arName1[] = name1.split(" ");
//		String arName2[] = name2.split(" ");
//		if(arName1[arName1.length - 1].length() == 1 || arName2[arName2.length - 1].length() == 1) {
//			if(Character.toLowerCase(arName1[arName1.length - 1].charAt(0))
//					!= Character.toLowerCase(arName2[arName2.length - 1].charAt(0))) {
//				return "no match";
//			}
//		}
//		 else {
//			 if (!(arName1[arName1.length - 1].equalsIgnoreCase(arName2[arName2.length - 1]))){
//					return "no match";
//				}
//		 }
//		if(arName1.length == 1 && arName1.length == arName2.length) {
//			return "match";
//		}				
//		return compareFirstName(arName1, arName2);
//	}
//	private static String compareFirstName(String[] arName1, String[] arName2) {
//		for(int i = 0; i < arName1.length - 1; i++) {
//			for (int j = 0; j < arName2.length - 1; j++) {
//				if (arName1[i].equalsIgnoreCase(arName2[j])) {
//					return "match";
//				} 
//			}
//		}
//		return "no match";
//	}
	static public String matches(String name1, String name2) {
		//TODO
//      String matches(String name1, String name2)
//      Names match under the following conditions, after breaking each one into "name parts" on whitespace :
//      - Two name parts match if they are the same (case insensitive) or one is a single letter initial and the other is longer but starts with the same letter.
//      - A name part in  the name1 may be missing from the name2
//      - Name parts in one name must not contradict name parts in the other
//      - Name parts that match must be in the same order in both names
		String match = "match";
		String noMatch = "no match";
		String partsName1[] = name1.split(" ");
		String partsName2[] = name2.split(" ");
		int indPartsName2 = 0;
		boolean flMatch = false;
		for (int i = 0; i < partsName1.length; i++) {
			flMatch = partMatch(partsName1[i], partsName2[indPartsName2]);
			if (flMatch) {
				indPartsName2++;
				if (indPartsName2 == partsName2.length) {
					return match;
				}
			}
		}
		return noMatch;
	}
	private static boolean partMatch(String part1, String part2) {
		part1 = part1.toLowerCase();
		part2 = part2.toLowerCase();
		boolean res = false;
		if (part1.compareTo(part2) == 0) {
			res = true;
		} else if(isSameInitial(part1, part2)) {
			res = true;
		} 
		return res;
	}
	private static boolean isSameInitial(String part1, String part2) {
		String partI = part1.length() == 1 ? part1 : part2;
		String partF = part1 == partI ? part2 : part1;
		return partI.length() == 1 && partF.startsWith(partI);
	}
	
	static public void sortStringsAsNumbers(String[] strNumbers) {
		int lookupTable[] = new int[1000];
		fillLookupTable(lookupTable, strNumbers);
		getResSortStrAsNum(lookupTable, strNumbers);
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
	
	
	public static boolean isIPv4(String ipV4str) {		
		return ipV4str.matches(ipV4Regex());
	}
	public static boolean isJavaVariable(String javaVariable) {		
		return javaVariable.matches(javaVariableRegex());
	}
	public static boolean isArithmeticExpression(String expression) {
		if(!checkParentheses(expression)) {
			return false;
		}	
		return removeSpacesAndParentheses(expression).matches(arithmeticExpression());
	}
	/**
	 * 
	 * @param expression
	 * @return true if for each '(' there is ')'
	 * examples: (ab)(dg(g)) - true
	 * (ab))((cd) - false
	 */
	private static boolean checkParentheses(String expression) {
		int strLength = expression.length();
		int parenthesesCount = 0;
		for(int i = 0; i < strLength; i++) {
			if(expression.charAt(i) == '(') {
				parenthesesCount++;
			} else if (expression.charAt(i) == ')') {
				parenthesesCount--;
				if(parenthesesCount < 0) {
					return false;
				}
			}
		}
		return parenthesesCount == 0 || false;
	}
	/**
	 * 
	 * @param expression
	 * returns string with no parentheses and no spaces
	 */
//	private static String removeSpacesAndParentheses(String expression) {
//		String resStr = expression.replaceAll("[() ]", ""); 
//		return resStr;		
//	}
	private static String removeSpacesAndParentheses(String expression) {
		return expression.replaceAll(" ", ""); 		
	}
}
