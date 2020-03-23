package contest.question9;

public class Solution {
    public String longestPrefix(String s) {
        int[] next = getNext(s);
        return s.substring(0, next[next.length - 1] + 1);
    }

    private static int[] getNext(String p) {
        int n = p.length(), j = -1;
        int[] next = new int[n];
        next[0] = -1;
        for (int i = 1; i < n; i++) {
            while (j != -1 && p.charAt(i) != p.charAt(j + 1)) {
                j = next[j];
            }
            if (p.charAt(i) == p.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}