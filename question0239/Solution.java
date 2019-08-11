package question0239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qianyihui
 * @date 2019-07-08
 *
 * 双端队列。在存入一个数字的下标之前，首先要判断队列里已有数字是否小于待存入的数字。如果已有数字小于待存入的数字，那么这些数字已经不可能是滑动
 * 窗口的最大值，因此它们将会被一次从队列的尾部删除。同时，如果队列头部的数字已经从窗口里滑出，那么滑出的数字也需要从队列的头部删除。由于队列的
 * 头部和尾部都有可能删除数字，这也是需要双端队列的原因。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度为O(k)。
 *
 * 执行用时：16ms，击败83.73%。消耗内存：41.1MB，击败95.61%。
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for (int i = k; i < n; i++) {
            result[index++] = nums[deque.getFirst()];
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            if (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }
            deque.addLast(i);
        }
        result[index] = nums[deque.getFirst()];
        return result;
    }
}
