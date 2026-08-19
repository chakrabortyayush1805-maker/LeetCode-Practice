import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowReservations = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col >= 2 && col <= 9) {
                rowReservations.put(row, rowReservations.getOrDefault(row, 0) | (1 << col));
            }
        }

        int maxGroups = 2 * n;

        // Mask representations for the 3 blocks:
        // Left:   seats 2, 3, 4, 5 -> (1<<2) | (1<<3) | (1<<4) | (1<<5) = 0b0000111100 = 60
        // Right:  seats 6, 7, 8, 9 -> (1<<6) | (1<<7) | (1<<8) | (1<<9) = 0b1111000000 = 960
        // Middle: seats 4, 5, 6, 7 -> (1<<4) | (1<<5) | (1<<6) | (1<<7) = 0b0011110000 = 240
        int leftMask = 60;
        int rightMask = 960;
        int middleMask = 240;

        for (int mask : rowReservations.values()) {
            boolean leftAvailable = (mask & leftMask) == 0;
            boolean rightAvailable = (mask & rightMask) == 0;
            boolean middleAvailable = (mask & middleMask) == 0;

            if (leftAvailable && rightAvailable) {
                continue;
            } else if (leftAvailable || rightAvailable || middleAvailable) {
                maxGroups -= 1;
            } else {
                maxGroups -= 2;
            }
        }

        return maxGroups;
    }
}