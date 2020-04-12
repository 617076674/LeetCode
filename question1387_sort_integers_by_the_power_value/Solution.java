package question1387_sort_integers_by_the_power_value;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 执行用时：72ms，击败64.72%。消耗内存：41MB，击败100.00%。
 */
public class Solution {
    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lo; i <= hi; i++) {
            map.put(i, weight(i));
        }
        Integer[] nums = new Integer[hi - lo + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = lo + i;
        }
        Arrays.sort(nums, (o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return o1 - o2;
            }
            return map.get(o1) - map.get(o2);
        });
        return nums[k - 1];
    }

    private int weight(long num) {
        int result = 0;
        while (num > 1) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num = 3 * num + 1;
            }
            result++;
        }
        return result;
    }
}