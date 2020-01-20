package question1239_maximum_length_of_a_concatenated_string_with_unique_characters;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 回溯法。
 *
 * 时间复杂度是O(2 ^ n)，其中n为arr的长度。空间复杂度是O(n)。
 *
 * 执行用时：40ms，击败35.91%。消耗内存：45MB，击败100.00%。
 */
public class Solution {
    private int result;

    private Set<Integer> set = new HashSet<>();

    {
        for (int i = 0; i < 26; i++) {
            set.add(i);
        }
    }

    public int maxLength(List<String> arr) {
        dfs(arr, 0);
        return result;
    }

    private void dfs(List<String> arr, int index) {
        if (result == 26) {
            return;
        }
        if (index == arr.size()) {
            result = Math.max(result, 26 - set.size());
            return;
        }
        //无视第index个元素
        dfs(arr, index + 1);
        String s = arr.get(index);
        Set<Integer> tmpSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            tmpSet.add(s.charAt(i) - 'a');
        }
        if (tmpSet.size() != s.length()) {
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i) - 'a')) {
                return;
            }
        }
        set.removeAll(tmpSet);
        dfs(arr, index + 1);
        set.addAll(tmpSet);
    }
}