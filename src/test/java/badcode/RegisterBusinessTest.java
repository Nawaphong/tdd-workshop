package badcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegisterBusinessTest {

	@Test
	@DisplayName("ทดสอบเรียกโดยไม่ส่ง First name")
	public void registerTest01() {
		RegisterBusiness business = new RegisterBusiness();
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			business.register(null, new Speaker());
		});
		assertEquals("First name is required.", exception.getMessage());
		
	}
	
	@Test
	@DisplayName("ทดสอบเรียกโดยส่ง First name ว่าง")
	public void registerTest02() {
		RegisterBusiness business = new RegisterBusiness();
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			Speaker speaker = new Speaker();
			speaker.setFirstName("");
			business.register(null, speaker);
		});
		assertEquals("First name is required.", exception.getMessage());
		
	}
	
	@Test
	@DisplayName("ทดสอบเรียกโดยส่ง First name")
	public void registerTest03() {
		RegisterBusiness business = new RegisterBusiness();
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			Speaker speaker = new Speaker();
			speaker.setFirstName("nawaphong");
			business.register(null, speaker);
		});
		assertEquals("Last name is required.", exception.getMessage());
		
	}
	
	@Test
	@DisplayName("ทดสอบเรียกโดยส่ง Last name ว่าง")
	public void registerTest04() {
		RegisterBusiness business = new RegisterBusiness();
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			Speaker speaker = new Speaker();
			speaker.setFirstName("nawaphong");
			speaker.setLastName("");
			business.register(null, speaker);
		});
		assertEquals("Last name is required.", exception.getMessage());
		
	}

	@Test
	@DisplayName("ทดสอบเรียกโดยส่ง Last name")
	public void registerTest05() {
		RegisterBusiness business = new RegisterBusiness();
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			Speaker speaker = new Speaker();
			speaker.setFirstName("nawaphong");
			speaker.setLastName("oncharun");
			business.register(null, speaker);
		});
		assertEquals("Email is required.", exception.getMessage());
		
	}
	
	@Test
	@DisplayName("ทดสอบเรียกโดยส่ง Email ว่าง")
	public void registerTest06() {
		RegisterBusiness business = new RegisterBusiness();
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			Speaker speaker = new Speaker();
			speaker.setFirstName("nawaphong");
			speaker.setLastName("oncharun");
			speaker.setEmail("");
			business.register(null, speaker);
		});
		assertEquals("Email is required.", exception.getMessage());
		
	}
	
	@Test
	@DisplayName("ทดสอบเรียกโดยส่ง Email")
	public void registerTest07() {
		RegisterBusiness business = new RegisterBusiness();
		Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
			Speaker speaker = new Speaker();
			speaker.setFirstName("nawaphong");
			speaker.setLastName("oncharun");
			speaker.setEmail("nawaphong@abc.com");
			business.register(null, speaker);
		});
		assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
		
	}
	
	@Test
	@DisplayName("ทดสอบเรียกโดยส่ง Email gmail")
	public void registerTest08() {
		RegisterBusiness business = new RegisterBusiness();
		Exception exception = assertThrows(SaveSpeakerException.class, () -> {
			Speaker speaker = new Speaker();
			speaker.setFirstName("nawaphong");
			speaker.setLastName("oncharun");
			speaker.setEmail("nawaphong@gmail.com");
			business.register(null, speaker);
		});
		assertEquals("Can't save a speaker.", exception.getMessage());
		
	}
}
