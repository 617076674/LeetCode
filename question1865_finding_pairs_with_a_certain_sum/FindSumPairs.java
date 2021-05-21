package question1865_finding_pairs_with_a_certain_sum;

import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {

    private int[] nums1, nums2;

    private Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        for (int num1 : nums1) {
            map1.put(num1, map1.getOrDefault(num1, 0) + 1);
        }
        this.nums2 = nums2;
        for (int num2 : nums2) {
            map2.put(num2, map2.getOrDefault(num2, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int origin = map2.get(nums2[index]);
        if (map2.get(nums2[index]) == 1) {
            map2.remove(nums2[index]);
        } else {
            map2.put(nums2[index], origin - 1);
        }
        nums2[index] += val;
        map2.put(nums2[index], map2.getOrDefault(nums2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
            result += entry1.getValue() * map2.getOrDefault(tot - entry1.getKey(), 0);
        }
        return result;
    }

}