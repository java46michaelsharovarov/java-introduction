package telran.text;

import java.util.regex.Pattern;

public class RegularExpressions {
	static String javaVariableRegex = "[a-zA-Z$][\\w$]*|_[\\w$]+";	
	static String doubleNumRegex = "((\\d*)\\.(\\d+))";
	//Correct operand: either java variable or integer number or double number
	static String correctOperandRegex = javaVariableRegex+ "|\\d+|" + doubleNumRegex;
	static String arithmeticExpression() {
		return String.format("\\(*(%s)\\)*([+*/-]\\(*(%1$s)\\)*)+", correctOperandRegex);
	}
	public static Pattern arithmeticExpressionPattern =
			Pattern.compile(arithmeticExpression());
}
