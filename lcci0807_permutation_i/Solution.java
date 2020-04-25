package lcci0807_permutation_i;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法。
 *
 * 执行用时：13ms，击败72.05%。消耗内存：47.8MB，击败100.00%。
 */
public class Solution {
    private List<String> list = new ArrayList<>();

    public String[] permutation(String S) {
        permute(S.toCharArray(), 0, new StringBuilder());
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void permute(char[] chars, int index, StringBuilder sb) {
        int n = chars.length;
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        for (int i = index; i < n; i++) {
            swap(chars, i, index);
            sb.append(chars[index]);
            permute(chars, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            swap(chars, i, index);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}