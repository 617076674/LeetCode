package lcci0101_is_unique;

/**
 * https://leetcode-cn.com/problems/is-unique-lcci/
 *
 * 哈希表+位向量。
 *
 * 时间复杂度是O(n)，其中n为字符串astr的长度。空间复杂度是O(1)。
 */
public class Solution {
    public boolean isUnique(String astr) {
        int n;
        if (null == astr || (n = astr.length()) == 0) {
            return true;
        }
        int exist = 0;  //所有的数字都没有出现过
        for (int i = 0; i < n; i++) {
            int num = astr.charAt(i) - 'a';
            if (((exist >> num) & 1) == 1) {
                return false;
            }
            exist |= 1 << num;
        }
        return true;
    }
}