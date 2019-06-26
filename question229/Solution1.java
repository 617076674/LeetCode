package question229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.get(integer) > nums.length / 3) {
                result.add(integer);
            }
        }
        return result;
    }
}
