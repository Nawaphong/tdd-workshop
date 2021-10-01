package badcode;

import badcode.ArgumentNullException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegisterBusinessTest {

	@Test
	public void registerTest() {
		RegisterBusiness business = new RegisterBusiness();
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			business.register(null, new Speaker());
		});
		assertEquals("First name is required.", exception.getMessage());
		
	}

}
