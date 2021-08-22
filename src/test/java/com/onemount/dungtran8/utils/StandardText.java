package com.onemount.dungtran8.utils;

public class StandardText {

	public static String standardizeString(String text) {
		String result = "";
		text = text.substring(0, 1).toUpperCase() + text.substring(1, text.length());
		String[] textArray = text.split("(?=\\p{Upper})");
		for (int i = 0; i < textArray.length - 1; i++) {
			result = result + textArray[i] + " ";
		}
		result = result + textArray[textArray.length - 1];
		return result;
	}
}
