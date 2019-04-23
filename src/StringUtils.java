
public class StringUtils {
	
	private static final String NUMERAL_STRING = "\\d+";
	
	public static boolean isNumeral(String parameter) {
		return parameter.matches(NUMERAL_STRING);
	}
}
