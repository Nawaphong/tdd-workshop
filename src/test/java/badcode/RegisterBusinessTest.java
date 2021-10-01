package badcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

	@Test
	@DisplayName("ทดสอบเรียกโดยส่ง Email ผิด Syntax")
	public void registerTest09() {
		RegisterBusiness business = new RegisterBusiness();
		Exception exception = assertThrows(DomainEmailInvalidException.class, () -> {
			Speaker speaker = new Speaker();
			speaker.setFirstName("nawaphong");
			speaker.setLastName("oncharun");
			speaker.setEmail("@nawaphong@gmail.com");
			business.register(null, speaker);
		});

	}

	@Test
	@DisplayName("ทดสอบเรียกโดยสร้าง Repository")
	public void registerTest10() {
		RegisterBusiness business = new RegisterBusiness();
		Exception exception = assertThrows(RuntimeException.class, () -> {
			Speaker speaker = new Speaker();
			SpeakerRepository sp = new SpeakerRepository() {
				@Override
				public Integer saveSpeaker(Speaker speaker) {
					throw new RuntimeException("can't save");
				}
			};
			speaker.setFirstName("nawaphong");
			speaker.setLastName("oncharun");
			speaker.setEmail("nawaphong@gmail.com");
			business.register(sp, speaker);
		});
		assertEquals("Can't save a speaker.", exception.getMessage());
	}

	@Test
	@DisplayName("ทดสอบเรียกโดยสร้าง Repository และส่งค่าสำเร็จ")
	public void registerTest11() {
		RegisterBusiness business = new RegisterBusiness();
		Speaker speaker = new Speaker();
		SpeakerRepository sp = new SpeakerRepository() {
			@Override
			public Integer saveSpeaker(Speaker speaker) {
				return 100;
			}
		};
		speaker.setFirstName("nawaphong");
		speaker.setLastName("oncharun");
		speaker.setEmail("nawaphong@gmail.com");
		assertEquals(100,business.register(sp, speaker));
	}
	
//	@Test
//	@DisplayName("ทดสอบเรียกโดยส่ง Speaker exp=0")
//	public void registerTest12() {
//		RegisterBusiness business = new RegisterBusiness();
//		Speaker speaker = new Speaker();
//		SpeakerRepository sp = new SpeakerRepository() {
//			@Override
//			public Integer saveSpeaker(Speaker speaker) {
//				return speaker.getRegistrationFee();
//			}
//		};
//		speaker.setFirstName("nawaphong");
//		speaker.setLastName("oncharun");
//		speaker.setEmail("nawaphong@gmail.com");
//		speaker.setExp(0);
//		
//		assertEquals(500,business.register(sp, speaker));
//	}
//	
//	@Test
//	@DisplayName("ทดสอบเรียกโดยส่ง Speaker exp=2")
//	public void registerTest13() {
//		RegisterBusiness business = new RegisterBusiness();
//		Speaker speaker = new Speaker();
//		SpeakerRepository sp = new SpeakerRepository() {
//			@Override
//			public Integer saveSpeaker(Speaker speaker) {
//				return speaker.getRegistrationFee();
//			}
//		};
//		speaker.setFirstName("nawaphong");
//		speaker.setLastName("oncharun");
//		speaker.setEmail("nawaphong@gmail.com");
//		speaker.setExp(2);
//		
//		assertEquals(250,business.register(sp, speaker));
//	}
//	
//	@Test
//	@DisplayName("ทดสอบเรียกโดยส่ง Speaker exp=4")
//	public void registerTest14() {
//		RegisterBusiness business = new RegisterBusiness();
//		Speaker speaker = new Speaker();
//		SpeakerRepository sp = new SpeakerRepository() {
//			@Override
//			public Integer saveSpeaker(Speaker speaker) {
//				return speaker.getRegistrationFee();
//			}
//		};
//		speaker.setFirstName("nawaphong");
//		speaker.setLastName("oncharun");
//		speaker.setEmail("nawaphong@gmail.com");
//		speaker.setExp(4);
//		
//		assertEquals(100,business.register(sp, speaker));
//	}
//	
//	@Test
//	@DisplayName("ทดสอบเรียกโดยส่ง Speaker exp=6")
//	public void registerTest15() {
//		RegisterBusiness business = new RegisterBusiness();
//		Speaker speaker = new Speaker();
//		SpeakerRepository sp = new SpeakerRepository() {
//			@Override
//			public Integer saveSpeaker(Speaker speaker) {
//				return speaker.getRegistrationFee();
//			}
//		};
//		speaker.setFirstName("nawaphong");
//		speaker.setLastName("oncharun");
//		speaker.setEmail("nawaphong@gmail.com");
//		speaker.setExp(6);
//		
//		assertEquals(50,business.register(sp, speaker));
//	}
	
}
