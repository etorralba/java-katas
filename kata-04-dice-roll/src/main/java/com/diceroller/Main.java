package com.diceroller;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Initialization
        Scanner reader = new Scanner(System.in);

        System.out.println("Welcome to the 'Dice Roler'!");
        System.out.println("How many times you want to roll the dice?");

        // Get int
        int diceRollAmount = getInputInt(reader);
        reader.close();

        // Perform Dice Rolls
        List<Integer> rolls = DiceRoller.roll(diceRollAmount);

        // Print Statistics
        DiceRollResults result = new DiceRollResults(rolls);
        System.out.println(result);
    }

    public record DiceRollResults(List<Integer> diceRollResults){
        @Override
        public String toString() {return "Result is: " + "1:" + diceRollResults.get(0) + " | 2:" + diceRollResults.get(1)+ " | 3:" + diceRollResults.get(2)+ " | 4:" + diceRollResults.get(3) + " | 5:" + diceRollResults.get(4)+ " | 6:" + diceRollResults.get(5);}
    }

    public static String getInput(Scanner reader){
        String userInput = reader.nextLine();
        return userInput.toLowerCase();
    }

    public static int getInputInt(Scanner reader){
        while(true){
            String userInput = getInput(reader);
            try {
                return Integer.parseInt(userInput);
            }catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }
}
