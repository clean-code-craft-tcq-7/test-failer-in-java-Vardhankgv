package testfailer;

import static org.junit.Assert.*;

import org.junit.Test;
import testfailer.Tshirts;

public class TShirtsTest {
    
    @Test
    public void testTshirtSizeForSmallShoulderLength() {
        assertEquals("S", Tshirts.getTShirtSize(37));
    }

    @Test
    public void testTshirtSizeForMediumShoulderLength() {
        assertEquals("M", Tshirts.getTShirtSize(39));
        assertEquals("M", Tshirts.getTShirtSize(41));
    }

    @Test
    public void testTshirtSizeForLargeShoulderLength() {
        assertEquals("L", Tshirts.getTShirtSize(42));
        assertEquals("L", Tshirts.getTShirtSize(100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTshirtSizeForNegativeLength() {
        Tshirts.getTShirtSize(-1);
    }

    @Test
    public void testTshirtSizeForBoundaryShoulderLengths() {
        assertEquals("M", Tshirts.getTShirtSize(38));
        assertEquals("L", Tshirts.getTShirtSize(42));
    }
}
