package by.proslau;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTest {

	@Test
	public void testReverse() {
		String input = "abc";
		String reverse = "cba";
		assertEquals("Error reverse", new StringBuilder(input).reverse().toString(), reverse);
	}

}
