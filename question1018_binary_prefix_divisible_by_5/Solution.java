package question1018_binary_prefix_divisible_by_5;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间复杂度是O(n)，其中n是数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败94.78%。消耗内存：42.2MB，击败5.43%。
 */
public class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int num = 0;
        for (int a : A) {
            num = ((num << 1) + a) % 5;
            if (num == 0) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}