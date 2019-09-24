package question0521_longest_uncommon_subsequence_i;

/**
 * 时间复杂度是O(min(n1, n2))，其中n1为字符串a的长度，n2为字符串b的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：33.8MB，击败86.64%。
 */
public class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
