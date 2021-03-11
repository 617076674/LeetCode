package question1673_find_the_most_competitive_subsequence;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 和 LeetCode 402 一模一样。
 */
public class Solution {

    public int[] mostCompetitive(int[] nums, int k) {
        int[] result = new int[k];
        Deque<Integer> stack = new LinkedList<>();
        int removed = nums.length - k;
        for (int num : nums) {
            while (!stack.isEmpty() && removed > 0 && stack.peekLast() > num) {
                stack.pollLast();
                removed--;
            }
            stack.addLast(num);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pollFirst();
        }
        return result;
    }

}