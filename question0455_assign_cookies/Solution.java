package question0455_assign_cookies;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index1 = 0, index2 = 0, result = 0;
        while (index1 < g.length && index2 < s.length) {
            if (s[index2] >= g[index1]) {
                result++;
                index1++;
                index2++;
            } else {
                index2++;
            }
        }
        return result;
    }
}