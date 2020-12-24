package lcof38_zi_fu_chuan_de_pai_lie;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<String> list = new ArrayList<>();

    private int[] map;

    private int len;

    private StringBuilder sb = new StringBuilder();

    public String[] permutation(String s) {
        map = new int[26];
        len = s.length();
        for (int i = 0; i < len; i++) {
            map[s.charAt(i) - 'a']++;
        }
        dfs();
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void dfs() {
        if (sb.length() == len) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                map[i]--;
                sb.append((char) ('a' + i));
                dfs();
                sb.deleteCharAt(sb.length() - 1);
                map[i]++;
            }
        }
    }

}