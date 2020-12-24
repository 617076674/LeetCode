package lcof59_i_hua_dong_chuang_kou_de_zui_da_zhi;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            if (!deque.isEmpty() && deque.peekFirst() + k <= i) {
                deque.pollFirst();
            }
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }

}