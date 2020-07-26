package question1067_digit_count_in_range;

/**
 * 时间复杂度是 O(log(high))。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败32.14%。消耗内存：36.2MB，击败100.00%。
 */
public class Solution {
    public int digitsCount(int d, int low, int high) {
        return digitsCountHelper(d, high) - digitsCountHelper(d, low - 1);
    }

    /**
     * 计算数字 d 在 [1, num] 间出现的次数
     */
    private int digitsCountHelper(int d, int num) {
        String s = String.valueOf(num);
        int result = 0, n = s.length();
        if (n == 1) {
            return d <= num && d != 0 ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (i == 0) {
                if (d != 0) {
                    if (d == digit) {
                        result += Integer.parseInt(s.substring(1)) + 1;
                    } else if (d < digit) {
                        result += Math.pow(10, n - 1);
                    }
                }
            } else if (i == n - 1) {
                if (d > digit) {
                    result += Integer.parseInt(s.substring(0, n - 1));
                    if (d == 0) {
                        result--;
                    }
                } else {
                    result += Integer.parseInt(s.substring(0, n - 1));
                    if (d != 0) {
                        result++;
                    }
                }
            } else {
                if (d == digit) {
                    if (d == 0) {
                        result += Integer.parseInt(s.substring(i + 1)) + (Integer.parseInt(s.substring(0, i)) - 1) * Math.pow(10, n - 1 - i) + 1;
                    } else {
                        result += Integer.parseInt(s.substring(i + 1)) + (Integer.parseInt(s.substring(0, i))) * Math.pow(10, n - 1 - i) + 1;
                    }
                } else if (d < digit) {
                    if (d == 0) {
                        result += (Integer.parseInt(s.substring(0, i)) - 1) * Math.pow(10, n - 1 - i) + Math.pow(10, n - 1 - i);
                    } else {
                        result += (Integer.parseInt(s.substring(0, i))) * Math.pow(10, n - 1 - i) + Math.pow(10, n - 1 - i);
                    }
                } else {
                    result += (Integer.parseInt(s.substring(0, i))) * Math.pow(10, n - 1 - i);
                }
            }
        }
        return result;
    }
}