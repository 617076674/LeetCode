package question0788_rotated_digits;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。
 *
 * 时间复杂度是O(N * log(N))。空间复杂度是O(1)。
 *
 * 执行用时：9ms，击败71.99%。消耗内存：33.1MB，击败95.58%。
 */
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    {
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(9, 6);
    }

    public int rotatedDigits(int N) {
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNumber(i)) {
                result++;
            }
        }
        return result;
    }

    private boolean isGoodNumber(int num) {
        boolean result = false;
        while (num > 0) {
            int tmp = num % 10;
            if (!map.containsKey(tmp)) {
                return false;
            }
            if (!map.get(tmp).equals(tmp)) {
                result = true;
            }
            num /= 10;
        }
        return result;
    }
}
