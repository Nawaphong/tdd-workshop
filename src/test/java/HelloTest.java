import static org.junit.Assert.*;

import org.junit.Test;

public class HelloTest {

	@Test
	public void test() {
		Hello hello = new Hello();
		
		String result = hello.say("nawaphong");
		
		assertEquals("Hello nawaphong", result);
	}

}
