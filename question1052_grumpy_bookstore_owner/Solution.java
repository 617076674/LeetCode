package question1052_grumpy_bookstore_owner;

public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length, sum = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        int left = 0, right = -1, window = 0, maxWindow = 0;
        while (right + 1 < n) {
            right++;
            if (grumpy[right] == 1) {
                window += customers[right];
            }
            if (right - left + 1 > X) {
                if (grumpy[left] == 1) {
                    window -= customers[left];
                }
                left++;
            }
            maxWindow = Math.max(maxWindow, window);
        }
        return sum + maxWindow;
    }
}