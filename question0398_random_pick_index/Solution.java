package question0398_random_pick_index;

import java.util.Random;

/**
 * 蓄水池原理：选择第i个节点的概率是1/i。
 *
 * 执行用时：86ms，击败50.16%。消耗内存：62.8MB，击败5.10%。
 */
public class Solution {
    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        Random random = new Random();
        int i = 1, result = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == target) {
                if (random.nextInt(i) == 0) {
                    result = j;
                }
                i++;
            }
        }
        return result;
    }
}