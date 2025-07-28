package testfailer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tshirts {

    private static final Logger LOG = LoggerFactory.getLogger(Tshirts.class);
    /**
     * Determines the size designation based on the given shoulder length in centimeters.
     *
     * @param shoulderLengthInCms the shoulder length measurement in centimeters
     * @return the size designation: "S" for small, "M" for medium, "L" for large
     * @throws IllegalArgumentException if the shoulder length value is negative
     */
    public static String getTShirtSize(int shoulderLengthInCms) {
        LOG.info("Received shoulder size in cms: {}", shoulderLengthInCms);
        if (shoulderLengthInCms < 0) {
            throw new IllegalArgumentException("Shoulder length cannot be negative.");
        }

        if(shoulderLengthInCms < 38) {
            return "S";
        } else if(shoulderLengthInCms < 42) {
            return "M";
        } else {
            return "L";
        }
    }
}
