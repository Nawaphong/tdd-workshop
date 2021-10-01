package badcode;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterBusiness {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[a-zA-Z0-9._%+-]+@([a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})$",
			Pattern.CASE_INSENSITIVE);

	public Integer register(SpeakerRepository repository, Speaker speaker) {
		Integer speakerId;

		// validate input
		validateInput(speaker);
		// Your Tasks ...

		// Save Speaker
		try {
			speakerId = repository.saveSpeaker(speaker);
		} catch (Exception exception) {
//                        	exception.printStackTrace();
			throw new SaveSpeakerException("Can't save a speaker.");
		}
		return speakerId;
	}

	private void validateInput(Speaker speaker) {
		if (isNullOrEmpty(speaker.getFirstName())) {
			throw new ArgumentNullException("First name is required.");
		}
		if (isNullOrEmpty(speaker.getLastName())) {
			throw new ArgumentNullException("Last name is required.");
		}
		if (isNullOrEmpty(speaker.getEmail())) {
			throw new ArgumentNullException("Email is required.");
		}

		final String[] domains = { "gmail.com", "live.com" };
		String emailDomain = getEmailDomain(speaker.getEmail()); // Avoid ArrayIndexOutOfBound
		System.out.println(Arrays.stream(domains).anyMatch(emailDomain::equals));
		if (!Arrays.stream(domains).anyMatch(emailDomain::equals)) {
			System.out.println(emailDomain);
			throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
		}
	}

	private boolean isNullOrEmpty(String inp) {
		return inp == null || inp.trim().equals("");
	}

	public String getEmailDomain(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		if(!matcher.find()) {
			throw new DomainEmailInvalidException();
		}else {
			return matcher.group(1);
		}
	}
}