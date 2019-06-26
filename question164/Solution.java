package question164;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        if (min == max) {
            return 0;
        }
        int[] maxBuckets = new int[nums.length + 1];
        Arrays.fill(maxBuckets, -1);
        int[] minBuckets = new int[nums.length + 1];
        Arrays.fill(minBuckets, -1);
        int capacity = (int) Math.ceil((double) (max - min) / (nums.length + 1));
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - min) / capacity;
            if (nums[i] == max) {   //最大值放进最后一个桶里
                index = nums.length;
            }
            if (maxBuckets[index] == -1) {
                maxBuckets[index] = nums[i];
            } else if (nums[i] > maxBuckets[index]) {
                maxBuckets[index] = nums[i];
            }
            if (minBuckets[index] == -1) {
                minBuckets[index] = nums[i];
            } else if (nums[i] < minBuckets[index]) {
                minBuckets[index] = nums[i];
            }
        }
        int result = 0;
        int pre = maxBuckets[0];    //第一个桶有min，一定不是空桶
        for (int i = 1; i < maxBuckets.length; i++) {
            if (maxBuckets[i] != -1) {
                result = Math.max(result, minBuckets[i] - pre);
                pre = maxBuckets[i];
            }
        }
        return result;
    }
}