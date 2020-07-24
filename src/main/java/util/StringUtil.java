package util;

public class StringUtil {
	
	public static Double stringForDoubleWithoutMoneySign(String text) {
		
		text = text.replace("$", "");
		return Double.parseDouble(text);
	}
}
