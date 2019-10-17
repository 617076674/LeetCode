package question0830_positions_of_large_groups;

import java.util.ArrayList;
import java.util.List;

/**
 * 双指针。
 *
 * 时间复杂度是O(n)，其中n为字符串S的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：36.5MB，击败94.94%。
 */
public class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        int n = S.length();
        for (int i = 0; i < n; ) {
            char c = S.charAt(i);
            int j = i;
            while (j + 1 < n && S.charAt(j + 1) == c) {
                j++;
            }
            if (j - i + 1 >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                result.add(list);
            }
            i = j + 1;
        }
        return result;
    }
}
