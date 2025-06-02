package com.diceroller;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiceRollerTest {

    @Test
   void testSingleDiceRoll() {
        List<Integer> diceRoll = DiceRoller.roll(1);
        int diceRollAddition = 0;
        for (int number : diceRoll) { diceRollAddition += number ; }
        assertInstanceOf(List.class, diceRoll);
        assertEquals(diceRollAddition, 1);
    }

    @Test
    void testMultipleDiceRolls() {
        List<Integer> diceRoll = DiceRoller.roll(100);
        int diceRollAddition = 0;
        for (int number : diceRoll) { diceRollAddition += number ; }
        assertInstanceOf(List.class, diceRoll);
        assertEquals(diceRollAddition, 100);
    }

    @Test
    void testZeroRolls() {
        List<Integer> diceRoll = DiceRoller.roll(0);
        int diceRollAddition = 0;
        for (int number : diceRoll) { diceRollAddition += number ; }
        assertInstanceOf(List.class, diceRoll);
        assertEquals(diceRollAddition, 0);
    }

    @Test
    void testNegativeRolls() {
        assertThrows(IllegalArgumentException.class, () -> DiceRoller.roll(-5));
    }


}
