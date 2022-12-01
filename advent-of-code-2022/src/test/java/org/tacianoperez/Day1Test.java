package org.tacianoperez;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test with provided input.
 */
public class Day1Test {
    @Test
    public void testWithProvidedInput() throws Exception {
        int maxCalories = Day1.countCalories("/workspaces/advent-of-code-2022/advent-of-code-2022/src/main/resources/input.txt");
        assertEquals(69177, maxCalories);
    }
}
