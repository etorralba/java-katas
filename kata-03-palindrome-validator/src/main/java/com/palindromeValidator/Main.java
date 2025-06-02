package com.palindromeValidator;
import com.palindromeValidator.PalindromeValidator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Welcome! Please type your sentence: ");
        String userInput = reader.nextLine();

        reader.close();

        System.out.println(PalindromeValidator.isPalindrome(userInput));
    }


}
