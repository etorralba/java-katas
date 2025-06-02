package com.diceroller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DiceRoller {
    public static List<Integer> roll (int rollAmount){
        if (rollAmount < 0){
            throw new IllegalArgumentException("Roll amount must be non-negative");
        }

        // Initialize counter
        List<Integer> counter = Arrays.asList(0,0,0,0,0,0);

        for (int i = 0; i < rollAmount; i++){
            // Perform Dice Roll
            Random random = new Random();
            int diceRoll = random.nextInt(6);
            int temp = counter.get(diceRoll) + 1;

            // Save Result
            counter.set(diceRoll, temp);
        }
        return counter;
    }
}
