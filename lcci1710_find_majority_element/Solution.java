package lcci1710_find_majority_element;

public class Solution {

    public int majorityElement(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return -1;
        }
        int result = nums[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (result == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    result = nums[i];
                    count = 1;
                }
            }
        }
        int times = 0;
        for (int num : nums) {
            if (num == result) {
                times++;
            }
        }
        return times > nums.length / 2 ? result : -1;
    }

}