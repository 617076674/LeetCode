package question1528_shuffle_string;

/**
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为字符串 s 的长度。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：39.7MB，击败88.30%。
 */
public class Solution {
    public String restoreString(String s, int[] indices) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return String.valueOf(chars);
    }
}