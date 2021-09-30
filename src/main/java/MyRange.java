import java.util.stream.IntStream;

public class MyRange {
	private static final char END_NUMBER_POS = 1;
	private static final int ASCII_TO_NUMBER = 48;
	private static final int PLUS_NUMBER_VAL_BY_EXCLUDE = 1;
	private static final int MINUS_NUMBER_VAL_BY_EXCLUDE = -1;
	private String input;

	public MyRange(String input) {
		this.input = input;
	}

	public boolean startWithInclude() {
		
		return input.startsWith("[");
	}
	
	public boolean endWithInclude() {
		return input.endsWith("]");
	}
	
	public int getStart() {
		if(startWithInclude()) {
			return input.charAt(1) - ASCII_TO_NUMBER;			
		} else if(startWithExclude()) {
			return input.charAt(1) + PLUS_NUMBER_VAL_BY_EXCLUDE - ASCII_TO_NUMBER;
		}
		return -1;
	}

	public int getEnd() {
		if(endWithInclude()) {
			return input.charAt((input.length() - 1) - END_NUMBER_POS) - ASCII_TO_NUMBER;		
		} else if(endWithExclude()) {
			return input.charAt((input.length() - 1) - END_NUMBER_POS) + MINUS_NUMBER_VAL_BY_EXCLUDE - ASCII_TO_NUMBER;
		}
		return -1;
	}

	public boolean startWithExclude() {
		return input.startsWith("(");
	}

	public boolean endWithExclude() {
		return input.endsWith(")");
	}

	public String result() {
		StringBuilder sb = new StringBuilder();
		for (int i=getStart();i<=getEnd();i++) {
			sb.append(i);
			sb.append(',');
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	public void validate() throws InputInvalidException {
		if(!input.startsWith("[") && !input.startsWith("(")) {
			throw new InputInvalidException("Input error");
		}
	}

}
