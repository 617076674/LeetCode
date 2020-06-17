package question1441_build_an_array_with_stack_operations;

import java.util.ArrayList;
import java.util.List;

/**
 * 双指针。
 *
 * 时间复杂度是 O(target.length)。空间复杂度是 O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.8MB，击败100.00%。
 */
public class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        // index1 遍历 [1, 2, ..., n]，指的是元素，不是索引；index2 遍历数组 target，指的是索引，不是元素
        int index1 = 1, index2 = 0;
        while (index2 < target.length) {
            if (target[index2] == index1) {
                index1++;
                index2++;
                result.add("Push");
            } else {
                index1++;
                result.add("Push");
                result.add("Pop");
            }
        }
        return result;
    }
}