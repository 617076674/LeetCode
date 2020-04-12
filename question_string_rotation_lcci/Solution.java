package question_string_rotation_lcci;

/**
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 *
 * 执行用时：0ms，击败100.00%。消耗内存：40.1MB，击败100.00%。
 */
public class Solution {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s2 + s2).contains(s1);
    }
}