package lcp12_xiao_zhang_shua_ti_ji_hua;

public class Solution {

    public int minTime(int[] time, int m) {
        int left = 0, right = 1000000000;
        while (left < right) {
            if (left + 1 == right) {
                if (check(time, m, left)) {
                    return left;
                }
                return right;
            }
            int mid = left + ((right - left) >> 1);
            if (check(time, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] time = {999,999,999};
        int m = 4;
        System.out.println(new Solution().minTime(time, m));
    }

    private boolean check(int[] time, int m, int T) {
        int max = Integer.MIN_VALUE, day = 0, cost = 0;
        for (int i = 0; i < time.length; i++) {
            cost += time[i];
            if (max != Integer.MIN_VALUE) {
                cost += max;
            }
            max = Math.max(max, time[i]);
            cost -= max;
            if (cost > T) {
                cost = 0;
                i--;
                day++;
                max = Integer.MIN_VALUE;
            }
        }
        return day < m;
    }

}