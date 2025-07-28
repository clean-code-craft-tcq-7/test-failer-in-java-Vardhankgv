package testfailer;

import static org.junit.Assert.*;

import org.junit.Test;
import testfailer.Misaligned;

public class MisalignedTest {

    @Test
    public void testGetTotalColorCombinations() {
        int expectedCombinations = 25;
        assertEquals(expectedCombinations, Misaligned.getTotalColorCombinations());
    }

    @Test
    public void testGetColorCombinationValidPairNumber() {
        assertArrayEquals(new String[]{"White", "Blue"}, Misaligned.getColorCombination(1));
        assertArrayEquals(new String[]{"Red", "Orange"}, Misaligned.getColorCombination(7));
        assertArrayEquals(new String[]{"Black", "Green"}, Misaligned.getColorCombination(13));
        assertArrayEquals(new String[]{"Yellow", "Brown"}, Misaligned.getColorCombination(19));
        assertArrayEquals(new String[]{"Violet", "Slate"}, Misaligned.getColorCombination(25));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetColorCombinationInvalidNegativePairNumber() {
        Misaligned.getColorCombination(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetColorCombinationInvalidPairNumberHigh() {
        Misaligned.getColorCombination(26);
    }
}
