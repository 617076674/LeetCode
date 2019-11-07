package question0046_permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法。采用swap()操作来代替Solution1中的list.contains()操作。
 *
 * 把nums数组分成两部分，一部分是数组中的第一个元素，另一个部分是数组中的其他元素，接下来求其他元素的全排列。
 *
 * 拿第一个字符和它后面的字符逐个交换。
 *
 * 时间复杂度是O(n)，其中n是nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：3ms，击败88.85%。消耗内存：38.7MB，击败60.19%。
 */
public class Solution2 {
    private List<List<Integer>> listList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0, new ArrayList<>());
        return listList;
    }

    private void permute(int[] nums, int index, List<Integer> list) {
        int n = nums.length;
        if (list.size() == n) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < n; i++) {
            swap(nums, i, index);
            list.add(nums[index]);
            permute(nums, index + 1, list);
            list.remove(list.size() - 1);
            swap(nums, i, index);   //注意变量的回溯
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}