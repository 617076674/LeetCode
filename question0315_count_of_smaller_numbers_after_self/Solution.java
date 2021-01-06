package question0315_count_of_smaller_numbers_after_self;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sorted = new ArrayList<>(), result = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = floor(sorted, 0, nums[i]);
            sorted.add(index + 1, nums[i]);
            result.add(index + 1);
        }
        Collections.reverse(result);
        return result;
    }

    private int floor(List<Integer> nums, int size, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums.get(mid) == target) {
                right = mid - 1;
            } else if (nums.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}