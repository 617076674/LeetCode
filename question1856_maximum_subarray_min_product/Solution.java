package question1856_maximum_subarray_min_product;

import java.util.LinkedList;

public class Solution {

    public int maxSumMinProduct(int[] nums) {
        int[] right = new int[nums.length];
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!linkedList.isEmpty() && nums[linkedList.peekLast()] > nums[i]) {
                right[linkedList.pollLast()] = i;
            }
            linkedList.addLast(i);
        }
        while (!linkedList.isEmpty()) {
            right[linkedList.pollLast()] = nums.length;
        }
        int[] left = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!linkedList.isEmpty() && nums[linkedList.peekLast()] > nums[i]) {
                left[linkedList.pollLast()] = i;
            }
            linkedList.addLast(i);
        }
        while (!linkedList.isEmpty()) {
            left[linkedList.pollLast()] = -1;
        }
        long[] sums = new long[nums.length + 1];  // sums[i] = nums[0] + ... + nums[i - 1]
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, nums[i] * (sums[right[i]] - sums[left[i] + 1]));
        }
        return (int) (result % 1000000007);
    }

}