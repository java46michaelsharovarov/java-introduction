package telran.text;

public class RegularExpressions {
	public static String arithmeticExpression() {
		return String.format("\\(*(%1$s)\\)*([+*/-]\\(*(%1$s)\\)*)+", correctOperandRegex());
	}
	private static String correctOperandRegex() {
		//Correct operand: either java variable or integer number or double number
		return String.format("%1$s|\\d+|%2$s", javaVariableRegex(), doubleNumberRegex());
	}
	public static String javaVariableRegex() {			
		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
		}	
	private static String doubleNumberRegex() {
		return "((\\d*)\\.(\\d+))";
	}
}
