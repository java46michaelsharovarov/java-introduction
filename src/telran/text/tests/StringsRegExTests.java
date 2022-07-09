package telran.text.tests;

import static org.junit.jupiter.api.Assertions.*;
import static telran.text.Strings.*;

import org.junit.jupiter.api.Test;

class StringsRegExTests {
//	@Test
//	void javaVariableTrue() {		
//		assertTrue(isJavaVariable("__"));
//		assertTrue(isJavaVariable("$"));
//		assertTrue(isJavaVariable("$_"));
//		assertTrue(isJavaVariable("abc"));
//		assertTrue(isJavaVariable("abc100"));
//		assertTrue(isJavaVariable("$2"));
//		assertTrue(isJavaVariable("_2"));		
//	}
//	@Test
//	void javaVariableFalse() {
//		assertFalse(isJavaVariable("2_"));
//		assertFalse(isJavaVariable("_"));
//		assertFalse(isJavaVariable("a 2"));		
//	}
//	@Test
//	void ipV4True() {
//		assertTrue(isIPv4("0.0.0.0"));
//		assertTrue(isIPv4("250.0.199.200"));
//		assertTrue(isIPv4("250.0.199.249"));
//		assertTrue(isIPv4("001.0.2.0"));
//		assertTrue(isIPv4("255.255.255.255"));
//	}
//	@Test
//	void ipV4False() {
//		assertFalse(isIPv4("0.0.0.0.0"));
//		assertFalse(isIPv4("0.*.10.0"));
//		assertFalse(isIPv4("-10.0.0.0"));
//		assertFalse(isIPv4("100..10.1.1"));
//		assertFalse(isIPv4("100.10.1.256"));
//		assertFalse(isIPv4("a.10.1.1"));		
//	}
	@Test
	void isArithmeticExpressionTrue() {
		assertTrue(isArithmeticExpression("(125 + ((9)))"));
		assertTrue(isArithmeticExpression("125 + 9.81 * 12.0 / .19 - __"));
		assertTrue(isArithmeticExpression("(abc + (1 * $_)) / _8"));
		assertTrue(isArithmeticExpression("((aB123/_R) + (1.056 * 0.9)) / $_"));
	}
	@Test
	void isArithmeticExpressionFalse() {
		assertFalse(isArithmeticExpression("9 + 1."));
		assertFalse(isArithmeticExpression("9 / _"));
		assertFalse(isArithmeticExpression("- 9"));
		assertFalse(isArithmeticExpression("1 + -9"));
		assertFalse(isArithmeticExpression(""));
		assertFalse(isArithmeticExpression("908"));
		assertFalse(isArithmeticExpression("& -"));
		assertFalse(isArithmeticExpression("$ - _2 / &"));
		assertFalse(isArithmeticExpression("((ab + (1 * 9)) / 2"));
		assertFalse(isArithmeticExpression(")a + (1 * 9)) / __"));
		assertFalse(isArithmeticExpression("(a + (1 * 9))) / __"));
		assertFalse(isArithmeticExpression("ab + (1 * ) 9 / 2"));
	}	
}
