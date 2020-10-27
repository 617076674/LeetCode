package question0763_partition_labels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 滑动窗口法。
 *
 * 时间复杂度是O(n)，其中n为字符串S的长度。空间复杂度是O(1)。
 *
 * 执行用时：8ms，击败50.75%。消耗内存：35.7MB，击败82.91%。
 */
public class Solution {

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];   //记录每个字符最后出现的索引
        Arrays.fill(last, Integer.MIN_VALUE);
        int n = S.length();
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            last[c - 'a'] = Math.max(i, last[c - 'a']);
        }
        int left = 0, right = -1;
        List<Integer> result = new ArrayList<>();
        while (right + 1 < n) {
            right++;
            for (int i = left; i <= right; i++) {
                right = Math.max(right, last[S.charAt(i) - 'a']);   //根据滑动窗口里的值不断更新滑动窗口的右边界
            }
            result.add(right - left + 1);
            left = right + 1;
        }
        return result;
    }

}