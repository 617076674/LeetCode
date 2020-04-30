package question0202_happy_number;

import java.util.HashSet;
import java.util.Set;

/**
 * 执行用时：2ms，击败51.98%。消耗内存：36.3MB，击败8.33%。
 */
public class Solution {
    private Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1) {
            int num = next(n);
            if (set.contains(num)) {
                return false;
            }
            set.add(n);
            n = num;
        }
        return true;
    }

    private int next(int n) {
        int result = 0;
        while (n > 0) {
            int num = n % 10;
            result += num * num;
            n /= 10;
        }
        return result;
    }
}