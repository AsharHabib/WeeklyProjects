package com.revature;

public class Main {

	public static void main(String[] args) {
		System.out.println(validateCard(1234567890123456L));
		System.out.println(validateCard(1234567890123452L));
	}
	
	public static boolean validateCard(Long num) {
		boolean result = false;
		
		StringBuilder number = new StringBuilder(num.toString());
		int len = number.length() - 1;
		Character finalDigit = number.charAt(len);
		int lastDigit = Integer.parseInt(finalDigit.toString());
		int digits [] = new int[len];
		
		number.reverse();
		number.deleteCharAt(0);
		Integer sum = 0;
		for (int i = 0; i < len; i++) {
			Character digit = number.charAt(i);
			digits[i] = Integer.parseInt(digit.toString());
			if (i % 2 == 0) {
				Integer doubled = digits[i] * 2;
				if (doubled > 9) {
					String doubledString = doubled.toString();
					Character first = doubledString.charAt(0);
					int firstDigit = Integer.parseInt(first.toString());
					Character second = doubledString.charAt(1);
					int secondDigit = Integer.parseInt(second.toString());
					doubled = firstDigit + secondDigit;
				}
				sum += doubled;
			}
			else {
				sum += digits[i];
			}
		}
		StringBuilder sumSB = new StringBuilder(sum.toString());
		Character lastDigitSum = sumSB.charAt(sumSB.length() - 1);
		int finalDigitSum = 10 - Integer.parseInt(lastDigitSum.toString());
		if (lastDigit == finalDigitSum) result = true;
		return result;
	}
}
