package lcci0809_bracket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    private Set<String> set = new HashSet<>();

    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(new StringBuilder(), 0, 0);
        return new ArrayList<>(set);
    }

    private void dfs(StringBuilder sb, int cntLeft, int cntRight) {
        if (sb.length() == 2 * n) {
            set.add(sb.toString());
            return;
        }
        if (cntLeft < n) {
            sb.append('(');
            dfs(sb, cntLeft + 1, cntRight);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (cntLeft > cntRight) {
            sb.append(')');
            dfs(sb, cntLeft, cntRight + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}