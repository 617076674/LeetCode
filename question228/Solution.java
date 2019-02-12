package question228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i + 1 < nums.length && nums[i + 1] - 1 > nums[i]){
                if(i - left == 0){
                    result.add(String.valueOf(nums[i]));
                }else{
                    result.add(nums[left] + "->" + nums[i]);
                }
                left = i + 1;
            }
        }
        if(left == nums.length - 1){
            result.add(String.valueOf(nums[left]));
        }else{
            result.add(nums[left] + "->" + nums[nums.length - 1]);
        }
        return result;
    }
}
