package LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

	public List<String> result = new ArrayList<>();

	public StringBuilder sb = new StringBuilder();

	public String[] digitMapStr = { "", "", "abc", "def", "ghi", "jkl", "mno",
			"pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {

		digits = digits.replaceAll("0", "");
		digits = digits.replaceAll("1", "");
		
		if(digits.length() == 0) {
			return result;
		}

		if (digits.length() == 1) {
			String str = digitMapStr[digits.charAt(0) - '0'];
			for (int i = 0; i < str.length(); i++) {
				sb.append(str.charAt(i));
				result.add(sb.toString());
				sb.deleteCharAt(sb.length() - 1);
			}
		} else {
			String str = digitMapStr[digits.charAt(0) - '0'];
			for (int j = 0; j < str.length(); j++) {
				sb.append(str.charAt(j));
				letterCombinations(digits.substring(1, digits.length()));
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String digits = "234";
		System.out.println(new LetterCombinationsofaPhoneNumber()
				.letterCombinations(digits));
	}
}
