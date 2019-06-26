package question189;

/**
 * 还是以数组[1, 2, 3, 4, 5, 6, 7]向右移动3位为例，其结果是[5, 6, 7, 1, 2, 3, 4]。
 * <p>
 * 对于每一个位置的值，其最终位置其实我们都是可以确定的。问题的关键在于，我们如何处理这么一个循环调换的过程呢？
 * <p>
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 * <p>
 * 执行用时：1ms，击败97.82%。消耗内存：35.8MB，击败96.71%。
 */
public class Solution3 {

    public void rotate(int[] nums, int k) {
        if (0 == nums.length) {
            return;
        }
        k %= nums.length;
        int count = 0;      //用来记录交换次数，当交换次数达到n - 1次时交换完成
        for (int start = 0; count < nums.length - 1; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

}
