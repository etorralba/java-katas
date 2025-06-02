package com.palindromeValidator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PalindromeValidatorTest {

    @Test
    void testSimplePalindrome(){
        assertTrue(PalindromeValidator.isPalindrome("oso"));
    }

    @Test
    void testWithSpacesPunctuationAndCapitalLetters(){
        assertTrue(PalindromeValidator.isPalindrome(".Anita lava La Tina"));
    }

    @Test
    void testNonPalindrome(){
        assertFalse(PalindromeValidator.isPalindrome("this is not a palindrome"));
    }

    @Test
    void testEmptyString(){
        assertTrue(PalindromeValidator.isPalindrome(""));
    }

    @Test
    void testNullInput(){
        assertFalse((PalindromeValidator.isPalindrome(null)));
    }
}
