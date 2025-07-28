package testfailer;

public class Misaligned {

    private static final String[] MAJOR_COLORS = {"White", "Red", "Black", "Yellow", "Violet"};
    private static final String[] MINOR_COLORS = {"Blue", "Orange", "Green", "Brown", "Slate"};

    /**
     * Returns the color combination for a given index.
     *
     * @param pairCode the index of the color combination
     * @return a string array containing the major and minor color for the given index
     * @throws IllegalArgumentException if the index is out of bounds
     */
    public static String[] getColorCombination(int pairCode) {
        // Convert 1-based index to 0-based index
        int zeroBasedIndex = pairCode - 1;

        if (pairCode < 0 || pairCode > getTotalColorCombinations()) {
            throw new IllegalArgumentException("Invalid pair number " + pairCode);
        }
        
        int majorIndex = zeroBasedIndex / MINOR_COLORS.length;
        int minorIndex = zeroBasedIndex % MINOR_COLORS.length;

        return new String[]{MAJOR_COLORS[majorIndex], MINOR_COLORS[minorIndex]};
    }

    /**
     * Prints the color map to the console.
     */
    public static void printColorMap() {
       for (int index = 1; index <= getTotalColorCombinations(); index++) {
            String[] colors = getColorCombination(index);
            System.out.printf("%-3d | %-6s | %-6s\n", index, colors[0], colors[1]);
        }
    }

    /**
     * Returns the total number of color combinations.
     *
     * @return the total number of color combinations
     */
    public static int getTotalColorCombinations() {
        return MAJOR_COLORS.length * MINOR_COLORS.length;
    }
}
