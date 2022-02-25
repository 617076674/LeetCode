package lcci0808_permutation_ii;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private Set<String> set = new HashSet<>();

    public String[] permutation(String S) {
        dfs(new StringBuilder(), S, 0);
        String[] result = new String[set.size()];
        int index = 0;
        for (String temp : set) {
            result[index++] = temp;
        }
        return result;
    }

    private void dfs(StringBuilder sb, String s, int status) {
       if (sb.length() == s.length()) {
           set.add(sb.toString());
           return;
       }
       for (int i = 0; i < s.length(); i++) {
           if ((status & (1 << i)) == 0) {
               sb.append(s.charAt(i));
               dfs(sb, s, status ^ (1 << i));
               sb.deleteCharAt(sb.length() - 1);
           }
       }
    }
}