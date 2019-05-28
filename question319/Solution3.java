package question319;

public class Solution3 {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    private int sqrt1(int n) {
        int left = 0, right = n / 2 + 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == n) {
                return (int) mid;
            } else if (mid * mid < n) {
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }
        }
        return right;
    }

    private int sqrt2(int n) {
        double pre = 0, cur = 1;
        while (Math.abs(pre - cur) >= 0.000001) {
            pre = cur;
            cur = (n + cur * cur) / (2 * cur);
        }
        return (int) pre;
    }
}
