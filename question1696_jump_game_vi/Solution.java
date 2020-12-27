package question1696_jump_game_vi;

import java.util.LinkedList;

public class Solution {
    
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(nums.length - 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = dp[linkedList.peekFirst()] + nums[i];
            while (!linkedList.isEmpty() && dp[linkedList.peekLast()] <= dp[i]) {
                linkedList.pollLast();
            }
            linkedList.addLast(i);
            if (linkedList.peekFirst() - i == k) {
                linkedList.pollFirst();
            }
        }
        return dp[0];
    }
    
}