package com.wipro.assignment.palindrome;

public class LongestPalindrome {

	public String findLongestPalindrome(String input) {
		if (input.isEmpty()) {
			return null;
		}
		if (input.length() == 1) {
			return input;
		}
		String longest = input.substring(0, 1);
		for (int i = 0; i < input.length(); i++) {
			String tempInput = helper(input, i, i);
			if (tempInput.length() > longest.length()) {
				longest = tempInput;
			}
			tempInput = helper(input, i, i + 1);
			if (tempInput.length() > longest.length()) {
				longest = tempInput;
			}
		}
		return longest;
	}

	public String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}

	public static void main(String[] args) {

		LongestPalindrome palindrome = new LongestPalindrome();

		String findLongestPalindrome = palindrome.findLongestPalindrome("HelloWelcomeemoclewHelloolle");

		System.out.println(findLongestPalindrome);

	}

}
