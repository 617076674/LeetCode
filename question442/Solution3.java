package question442;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]);
            if (nums[temp - 1] > 0) {
                nums[temp - 1] *= -1;
            } else {
                result.add(temp);
            }
        }
        return result;
    }

}
