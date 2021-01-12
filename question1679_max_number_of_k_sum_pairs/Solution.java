package question1679_max_number_of_k_sum_pairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxOperations(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int another = k - num;
            Integer times = map.get(another);
            if (null == times) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (times == 1) {
                    map.remove(another);
                } else {
                    map.put(another, times - 1);
                }
                result++;
            }
        }
        return result;
    }

}