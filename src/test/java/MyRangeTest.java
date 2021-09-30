import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MyRangeTest {

	@Test
	public void case01() {
		//Arrange
		String input = "[1,5]";
		MyRange range = new MyRange(input);
		boolean result = range.startWithInclude();
		assertTrue(result);
	}

}
