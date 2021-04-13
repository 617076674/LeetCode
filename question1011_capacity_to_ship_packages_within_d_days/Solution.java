package question1011_capacity_to_ship_packages_within_d_days;

public class Solution {

    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        int left = 1, right = sum;
        while (left < right) {
            if (left + 1 == right) {
                if (canSend(weights, D, left)) {
                    return left;
                }
                return right;
            }
            int mid = left + ((right - left) >> 1);
            if (canSend(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canSend(int[] weights, int D, int max) {
        int result = 1, filled = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > max) {
                return false;
            }
            if (filled + weights[i] > max) {
                filled = weights[i];
                result++;
            } else {
                filled += weights[i];
            }
        }
        return result <= D;
    }

}