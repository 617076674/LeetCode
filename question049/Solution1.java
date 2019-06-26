package question049;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82780749
 */

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listList = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            boolean newAnagrams = true;
            for (int j = 0; j < listList.size(); j++) {
                if (listList.get(j).isEmpty()) {
                    continue;
                }
                if (isAnagrams(strs[i], listList.get(j).get(0))) {
                    newAnagrams = false;
                    listList.get(j).add(strs[i]);
                    break;
                }
            }
            if (newAnagrams) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                listList.add(list);
            }
        }

        return listList;
    }

    private boolean isAnagrams(String s1, String s2) {
        int[] flag = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            flag[s1.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            flag[s2.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
