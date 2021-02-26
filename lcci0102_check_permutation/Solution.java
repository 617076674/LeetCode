package lcci0102_check_permutation;

/**
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 *
 * 哈希表。
 *
 * 时间复杂度是O(n1 + n2)，其中n1为字符串s1的长度，n2为字符串s2的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：37.3MB，击败100.00%。
 */
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int[] map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            map[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}