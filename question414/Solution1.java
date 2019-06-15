package question414;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author qianyihui
 * @date 2019-06-15
 *
 * 优先队列。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为nums数组的长度。
 *
 * 执行用时：27ms，击败7.76%。消耗内存：39.7MB，击败31.22%。
 */
public class Solution1 {

    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.isEmpty()) {
                priorityQueue.add(nums[i]);
            } else {
                if (!set.contains(nums[i])) {
                    if (priorityQueue.size() == 3 && nums[i] > priorityQueue.peek()) {
                        priorityQueue.poll();
                        priorityQueue.add(nums[i]);
                    } else if (priorityQueue.size() < 3) {
                        priorityQueue.add(nums[i]);
                    }
                }
            }
            set.add(nums[i]);
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        if (priorityQueue.size() == 3) {
            return priorityQueue.peek();
        }
        return max;
    }

}
