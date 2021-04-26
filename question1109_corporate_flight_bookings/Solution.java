package question1109_corporate_flight_bookings;

import java.util.Arrays;

public class Solution {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 2];
        for (int[] booking : bookings) {
            diff[booking[0]] += booking[2];
            diff[booking[1] + 1] -= booking[2];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[i] = diff[i + 1];
            } else {
                result[i] = result[i - 1] + diff[i + 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        System.out.println(Arrays.toString(new Solution().corpFlightBookings(bookings, 5)));
    }

}