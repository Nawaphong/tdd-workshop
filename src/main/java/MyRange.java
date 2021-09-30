
public class MyRange {
	private static final char END_NUMBER_POS = 1;
	private static final int ASCII_TO_NUMBER = 48;
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
		return input.charAt(1) - ASCII_TO_NUMBER;
	}

	public int getEnd() {
		return input.charAt((input.length() - 1) - END_NUMBER_POS) - ASCII_TO_NUMBER;
	}

	public boolean startWithExclude() {
		return input.startsWith("(");
	}

	public boolean endWithExclude() {
		return input.endsWith(")");
	}

}
