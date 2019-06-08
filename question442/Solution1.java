package question442;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] array = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (array[nums[i]] == nums[i]) {
                result.add(nums[i]);
            } else {
                array[nums[i]] = nums[i];
            }
        }
        return result;
    }

}
