package badcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RegisterBusinessGetFeeTest {

	@ParameterizedTest
	@CsvSource({
	    "0,500",
	    "1,500",
	    "2,250",
	    "3,250",
	    "4,100",
	    "5,100",
	    "8,50",
	    "9,50",
	    "10,0",
	})
	void registerTest15(int expYear, int feeValue) {
		Speaker speaker = new Speaker();
	    assertNotNull(expYear);
	    speaker.setExp(expYear);
	    int actualFee =  speaker.getRegistrationFee();
	    assertEquals(actualFee, feeValue);
	}
}

