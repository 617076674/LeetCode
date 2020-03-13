package question0169_majority_element;

/**
 * 随机算法。
 *
 * 时间复杂度是O(∞)。空间复杂度是O(1)。
 *
 * 执行用时：5ms，击败44.55%。消耗内存：50.6MB，击败25.28%。
 */
public class Solution6 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        while (true) {
            int num = nums[(int) (Math.random() * (n))], count = 0;
            for (int i = 0; i < n; i++) {
                if (num == nums[i]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return num;
            }
        }
    }
}