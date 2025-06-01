package com.palindromeValidator;

public class PalindromeValidator {
    public static boolean isPalindrome(String input){
        if(input == null) {
            return false;
        }
        // Normalize text
        String text = input.toLowerCase().trim().replaceAll("\\p{Punct}", "").replaceAll(" ", "");

        // Initializing pointers
        int l = 0;
        int r = text.length() - 1;

        // Check each character and compare it is it's the same in the other side
        while (l < r){
            if (text.charAt(l) != text.charAt(r)){
                return false;
            }
            l += 1;
            r -= 1;
        }
        return true;
    }
}
