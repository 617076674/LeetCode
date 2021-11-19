package question0434_number_of_segments_in_a_string;

/**
 * 双指针寻找单词数。
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：33.9MB，击败81.21%。
 */
public class Solution {

    public int countSegments(String s) {
        int n;
        if (null == s) {
            return 0;
        }
        s = s.trim();   //去除s中前缀空格和后缀空格的影响
        if ((n = s.length()) == 0) {
            return 0;
        }
        int index = 0, result = 0;
        while (index < n) {
            int i = index;
            while (i + 1 < n && s.charAt(i + 1) != ' ') {
                i++;
            }
            index = i + 1;
            result++;
            if (index == n) {
                break;
            }
            while (s.charAt(index) == ' ' && index + 1 < n) {
                index++;
            }
        }
        return result;
    }

}