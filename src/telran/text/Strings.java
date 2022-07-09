package telran.text;

import static telran.text.RegularExpressions.*;
public class Strings {	
	public static boolean isArithmeticExpression(String expression) {
		if(!checkParentheses(expression)) {
			return false;
		}	
		return removeSpacesAndParentheses(expression).matches(arithmeticExpression());
	}
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
	private static String removeSpacesAndParentheses(String expression) {
		return expression.replaceAll(" ", ""); 		
	}
}
