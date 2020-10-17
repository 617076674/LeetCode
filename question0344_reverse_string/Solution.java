package question0344_reverse_string;

/**
 * 时间复杂度是 O(n)，其中 n 为字符串 s 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败99.98%。消耗内存：45.4MB，击败66.46%。
 */
public class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}