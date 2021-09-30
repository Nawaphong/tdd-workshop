import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class MyRangeFailTest {

	@Test
	 @DisplayName("��鹵鹴��� [, ( ��ҹ�� input = 1,5]")
	public void case01() {
		// Test assert Exception with JUnit5 #1
		try {
			MyRange range = new MyRange("1,5]");
			range.validate();
			fail("��è�价�� Exception");
		} catch (InputInvalidException e) {
			if(!"Input error".equals(e.getMessage())) {
				fail("��ͤ������١");
			}
		}
	}

	@Test
	@DisplayName("��鹵鹴��� [,( ��ҹ�� input = 1,5] with junit 5")
	public void case02() {
		// Test assert Exception with JUnit5 #2
		MyRange range = new MyRange("1,5]");
        Exception e = assertThrows(InputInvalidException.class, range::validate);
        assertEquals("Input error", e.getMessage() );
	}
	
	@Test
	@DisplayName("ŧ���´��� ],) ��ҹ�� input = [1,5 with junit 5")
	public void case03() {
		// Test assert Exception with JUnit5 #3
		MyRange range = new MyRange("[1,5");
        Exception e = assertThrows(InputInvalidException.class, range::validate);
        assertEquals("Input error", e.getMessage() );
	}
}
