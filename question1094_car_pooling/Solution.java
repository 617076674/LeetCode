package question1094_car_pooling;

public class Solution {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] locations = new int[1001];
        for (int[] trip : trips) {
            locations[trip[1]] += trip[0];
            locations[trip[2]] -= trip[0];
        }
        int count = 0;
        for (int location : locations) {
            count += location;
            if (count > capacity) {
                return false;
            }
        }
        return true;
    }

}