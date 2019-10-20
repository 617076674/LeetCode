package question0893_groups_of_special_equivalent_strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表。
 *
 * 时间复杂度是O(n1 * log(n1) + n2 * log(n2) + ... + nk * log(nk))，其中n1、n2、...、nk分别是字符串数组A中第1、2、...、k个
 * 字符串的长度，k是字符串数组A的长度。空间复杂度是O(k)。
 *
 * 执行用时：5ms，击败97.78%。消耗内存：37MB，击败85.87%。
 */
public class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
            set.add(resortString(s));
        }
        return set.size();
    }

    private String resortString(String s) {
        int n = s.length(), half = n >> 1;
        char[] chars1, chars2;
        if ((n & 1) == 0) {
            chars1 = new char[half];
        } else {
            chars1 = new char[half + 1];
        }
        chars2 = new char[half];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((i & 1) == 0) {
                chars1[i >> 1] = c;
            } else {
                chars2[(i - 1) >> 1] = c;
            }
        }
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return String.valueOf(chars1) + String.valueOf(chars2);
    }
}
