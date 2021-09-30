import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MyRangeTest {

	@Test
	public void case01() {
		//Arrange
		//Check start with include
		String input = "[1,5]";
		MyRange range = new MyRange(input);
		boolean result = range.startWithInclude();
		assertTrue(result);
	}
	
	@Test
	public void case02() {
		//Arrange
		//Check end with include
		String input = "[1,5]";
		MyRange range = new MyRange(input);
		boolean result = range.endWithInclude();
		assertTrue(result);
	}
	
	@Test
	public void case03() {
		//Arrange
		//Check start with include 1 and return start by 1
		String input = "[1,5]";
		MyRange range = new MyRange(input);
		int result = range.getStart();
		assertEquals(1, result);
	}
	
	@Test
	public void case04() {
		//Arrange
		//Check end with 5 include and return end by 5
		String input = "[1,5]";
		MyRange range = new MyRange(input);
		int result = range.getEnd();
		assertEquals(5, result);
	}

}