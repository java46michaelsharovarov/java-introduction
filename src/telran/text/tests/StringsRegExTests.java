package telran.text.tests;

import static org.junit.jupiter.api.Assertions.*;
import static telran.text.Strings.*;

import org.junit.jupiter.api.Test;

class StringsRegExTests {
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
