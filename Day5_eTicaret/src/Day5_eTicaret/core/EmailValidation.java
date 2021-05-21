package Day5_eTicaret.core;

import java.util.regex.Pattern;

public class EmailValidation {

	final String format = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	public boolean checkEmail(String email) {

		Pattern pattern = Pattern.compile(format, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(email).find();

	}
}
