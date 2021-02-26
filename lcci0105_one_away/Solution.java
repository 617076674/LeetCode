package lcci0105_one_away;

/**
 * 时间复杂度是O(n1)，其中n1为字符串first的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败99.35%。消耗内存：39.4MB，击败100.00%。
 */
public class Solution {
    public boolean oneEditAway(String first, String second) {
        int n1 = first.length(), n2 = second.length();
        if (n1 == n2) {
            int diff = 0;
            for (int i = 0; i < n1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    diff++;
                }
            }
            return diff <= 1;
        }
        if (n1 > n2) {
            return oneEditAway(second, first);
        }
        if (n1 + 1 != n2) {
            return false;
        }
        if (second.startsWith(first)) {
            return true;
        }
        int index1 = 0, index2 = 0;
        while (index1 < n1 && index2 < n2) {
            if (first.charAt(index1) == second.charAt(index2)) {
                index1++;
            }
            index2++;
        }
        return index1 == n1 && index2 == n2;
    }
}