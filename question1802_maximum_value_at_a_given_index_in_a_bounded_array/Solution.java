package question1802_maximum_value_at_a_given_index_in_a_bounded_array;

public class Solution {

    public int maxValue(int n, int index, int maxSum) {
        long left = 1, right = maxSum - n + 1;
        while (left < right) {
            if (left + 1 == right) {
                if (calculateSum(n, index, right) <= 2 * maxSum) {
                    return (int) right;
                }
                return (int) left;
            }
            long mid = left + ((right - left) >> 1);
            long sum = calculateSum(n, index, mid);
            if (sum == 2 * maxSum) {
                return (int) mid;
            } else if (sum > 2 * maxSum) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    private long calculateSum(int n, int index, long mid) {
        long leftSum = 0, rightSum = 0;
        if (mid - index >= 1) {
            leftSum = (mid - index + mid) * (index + 1);
        } else {
            leftSum = (1 + mid) * mid + (index - mid + 1) * 2;
        }
        if (index < n - 1) {
            if (mid - n + index >= 0) {
                rightSum = (2 * mid - n + index) * (n - 1 - index);
            } else {
                rightSum = mid * (mid - 1) + (n - mid - index) * 2;
            }
        }
        return leftSum + rightSum;
    }

}