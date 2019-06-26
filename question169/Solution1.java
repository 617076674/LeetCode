package question169;

import java.util.HashMap;

public class Solution1 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.get(integer) > nums.length / 2) {
                return integer;
            }
        }
        return 0;
    }
}
