package question1087_brace_expansion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 回溯
 *
 * 执行用时：3ms，击败96.00%。消耗内存：38.2MB，击败100.00%。
 */
public class Solution {
    private List<List<Character>> listList = new ArrayList<>();

    private List<String> list = new ArrayList<>();

    public String[] expand(String S) {
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '{') {
                i++;
                List<Character> tmpList = new ArrayList<>();
                while (S.charAt(i) != '}') {
                    if (S.charAt(i) != ',') {
                        tmpList.add(S.charAt(i));
                    }
                    i++;
                }
                Collections.sort(tmpList);
                listList.add(tmpList);
            } else if (c != ','){
                List<Character> tmpList = new ArrayList<>();
                tmpList.add(S.charAt(i));
                listList.add(tmpList);
            }
        }
        expand(0, new StringBuilder());
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void expand(int index, StringBuilder sb) {
        if (index == listList.size()) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < listList.get(index).size(); i++) {
            sb.append(listList.get(index).get(i));
            expand(index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}