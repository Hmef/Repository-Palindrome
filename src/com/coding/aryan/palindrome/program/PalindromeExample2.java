package com.coding.aryan.palindrome.program;

import java.util.Scanner;

public class PalindromeExample2 {

	public static void main(String[] args) {
		
		String original, reverse = ""; // verify with = null;
		Scanner in = new Scanner(System.in);
		System.out.println(" Enter your input ");
		original = in.nextLine();
		int length = original.length();
		for(int i = length - 1 ; i>=0 ; i--) 
			reverse = reverse + original.charAt(i);
			if(original.equals(reverse))
				System.out.println("palindrome.");
			else
				System.out.println("not a palindrome.");

	}
}
