package com.simple;

import java.util.ArrayList;
import java.util.List;

public class MethodNameConvertor {

	/* Method returns the updated method Name string as per the given convention or
  	 returns a "Not Valid Input" error message/null  incase of Invalid Input */
	public static String convertMethodName(String input) {

		String subString = null;
		List<Character> outputcharList = null;

		if (input == null || input.equals("") || input.equals(" ")) {
			return null;
		}

		if (input.length() > 3 && input.startsWith("get", 0)) {

			outputcharList = new ArrayList<Character>();

			subString = input.substring(3);
			char[] subStringArray = subString.toCharArray();

			for (int i = 0; i < subStringArray.length; i++) {

				char ch = subStringArray[i];

				if (i != 0 && Character.isUpperCase(ch)) {
					outputcharList.add('_');
					outputcharList.add(ch);
				} else {
					outputcharList.add(ch);
				}
			}

		} else {
			return "Not Valid Input";
		}

		char[] outputCharArray = new char[outputcharList.size()];

		for (int i = 0; i < outputcharList.size(); i++) {
			outputCharArray[i] = outputcharList.get(i);
		}

		return new String(outputCharArray);
	}

	public static void main(String args[]) {

		System.out.println("OutputName : " + convertMethodName("getAccountName"));

	}
}
