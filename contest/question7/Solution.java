package contest.question7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1).equals(map.get(o2))) {
                    return o1 - o2;
                }
                return map.get(o1) - map.get(o2);
            }
        });
        return nums[k - 1];
    }

    private int weight(long num) {
        if (num == 1) {
            return 0;
        }
        if (num % 2 == 0) {
            return 1 + weight(num / 2);
        }
        return 1 + weight(3 * num + 1);
    }
}