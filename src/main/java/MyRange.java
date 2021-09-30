
public class MyRange {
	private static final char END_NUMBER_POS = 1;
	private static final int ASCII_TO_NUMBER = 48;
	private static final char ADD_NUMBER_VAL_BY_EXCLUDE = 1;
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
			return input.charAt(1) + ADD_NUMBER_VAL_BY_EXCLUDE - ASCII_TO_NUMBER;
		}
		return -1;
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
