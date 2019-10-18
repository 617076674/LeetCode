package question0859_buddy_strings;

/**
 * 时间复杂度是O(n)，其中n为字符串A的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败92.53%。消耗内存：37.4MB，击败80.28%。
 */
public class Solution {
    public boolean buddyStrings(String A, String B) {
        int n1 = A.length(), n2 = B.length();
        if (n1 != n2) {
            return false;
        }
        int[] count = new int[26];
        boolean flag = false;
        for (int i = 0; i < n1; i++) {
            char c = A.charAt(i);
            count[c - 'a']++;
            if (count[c - 'a'] >= 2) {
                flag = true;
                break;
            }
        }
        if (flag && A.equals(B)) {  //对于A与B完全相同的情况，如果A中有某个字符重复出现两次以上，我们可以交换这个字符的两个位置
            return true;
        }
        int index1 = -1, index2 = -1;
        for (int i = 0; i < n1; i++) {
            char c1 = A.charAt(i), c2 = B.charAt(i);
            if (c1 != c2) {
                if (index1 == -1) {
                    index1 = i;
                } else {
                    index2 = i;
                }
            }
        }
        if (index1 == -1 || index2 == -1) {
            return false;
        }
        if (A.charAt(index1) != B.charAt(index2) || A.charAt(index2) != B.charAt(index1)) {
            return false;
        }
        return true;
    }
}
