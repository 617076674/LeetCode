package question0525_contiguous_array;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            Integer index = map.get(count);
            if (null == index) {
                map.put(count, i);
            } else {
                result = Math.max(result, i - index);
            }
        }
        return result;
    }

}