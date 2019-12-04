package question0161_one_edit_distance;

/**
 * 插入和删除是两个互补的操作。
 *
 * 时间复杂度是O(max(n1, n2))，其中n1是字符串s的长度，n2是字符串t的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：36.5MB，击败100.00%。
 */
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if (n1 == n2) {
            int diff = 0;
            for (int i = 0; i < n1; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    diff++;
                }
            }
            return diff == 1;
        } else if (n1 + 1 == n2) {
            if (s.equals(t.substring(0, t.length() - 1))) { //对这个特殊情况做处理，即s是t的前缀
                return true;
            }
            int index1 = 0, index2 = 0;
            while (index1 < n1 && index2 < n2) {
                if (s.charAt(index1) == t.charAt(index2)) {
                    index1++;
                    index2++;
                } else {
                    index2++;
                }
            }
            return index1 == n1 && index2 == n2;
        } else if (n1 == n2 + 1) {
            return isOneEditDistance(t, s);
        }
        return false;
    }
}