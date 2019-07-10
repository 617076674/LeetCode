package question0202;

import java.util.HashSet;
import java.util.Set;

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
