package org.finalproject.input;

import java.util.Locale;

public class InputFormatter {

	public String clearFormatting(String input){
		return input.toLowerCase(Locale.forLanguageTag(input));
	}

	public String[] breakIntoWords(String input){
		return input.split(" ");
	}
}
