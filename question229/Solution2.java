package question229;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        int number1 = nums[0], count1 = 0, number2 = nums[0], count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1) {
                count1++;
            }else if (nums[i] == number2) {
                count2++;
            }else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            }else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1) {
                count1++;
            } else if (nums[i] == number2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3){
            result.add(number1);
        }
        if (count2 > nums.length / 3) {
            result.add(number2);
        }
        return result;
    }
}
