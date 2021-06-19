package question1870_minimum_speed_to_arrive_on_time;

public class Solution {

    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1, right = 10000000;
        while (left < right) {
            if (left + 1 == right) {
                if (canReach(dist, hour, left)) {
                    return left;
                }
                if (canReach(dist, hour, right)) {
                    return right;
                }
                return -1;
            }
            int mid = left + ((right - left) >> 1);
            if (canReach(dist, hour, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return canReach(dist, hour, left) ? left : -1;
    }

    private static boolean canReach(int[] dist, double hour, int speed) {
        double cur = 0;
        for (int len : dist) {
            cur = Math.ceil(cur);
            cur += len * 1.0 / speed;
        }
        return cur <= hour;
    }

}