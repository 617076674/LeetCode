package contest.question1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int sum = sum(i);
            if (!map.containsKey(sum)) {
                map.put(sum, 0);
            }
            map.put(sum, map.get(sum) + 1);
        }
        int max = 0;
        for (int count : map.values()) {
            max = Math.max(max, count);
        }
        int result = 0;
        for (int count : map.values()) {
            if (count == max) {
                result++;
            }
        }
        return result;
    }

    private int sum(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}