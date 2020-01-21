package question0049_group_anagrams;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * 时间复杂度是O(max(n, (m1)log(m1) + (m2)log(m2) + ... + (mk)log(mk)))，其中n是strs数组的长度，mk是strs数组中第k个字符串的长度。
 * 空间复杂度是O(n)。
 *
 * 执行用时：12ms，击败95.29%。消耗内存：44.5MB，击败88.15%。
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String tmp = String.valueOf(array);
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<>());
            }
            map.get(tmp).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}