package question0384;

/**
 * @author qianyihui
 * @date 2019-06-26
 *
 * 对于数组中第i个位置，随机选取[i, n - 1]中的一个元素与其交换，其中n为nums数组的长度。
 *
 * 时间复杂度和空间复杂度均是O(n)。
 *
 * 执行用时：263ms，击败87.89%。消耗内存：77.7MB，击败68.72%。
 */
public class Solution2 {
    private int[] init;

    public Solution2(int[] nums) {
        init = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            init[i] = nums[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return init;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = new int[init.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = init[i];
        }
        for (int i = 0; i < result.length; i++) {
            swap(result, i, (int) (Math.random() * (result.length - i) + i));
        }
        return result;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
