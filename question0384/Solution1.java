package question0384;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-06-26
 *
 * 将数组转换成List，用Math.rand()函数从List里随机取出一个元素。
 *
 * 时间复杂度是O(n ^ 2)，其中n为初始化时nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：301ms，击败58.06%。消耗内存：75.4MB，击败73.33%。
 */
public class Solution1 {
    private int[] init;

    public Solution1(int[] nums) {
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
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < init.length; i++) {
            list.add(init[i]);
        }
        for (int i = 0; i < result.length; i++) {
            int randomIndex = (int) (Math.random() * list.size());
            result[i] = list.get(randomIndex);
            list.remove(randomIndex);
        }
        return result;
    }
}
