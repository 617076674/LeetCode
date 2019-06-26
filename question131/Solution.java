package question131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> listList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        nextWords(s, 0, new ArrayList<>());
        return listList;
    }

    private void nextWords(String s, int index, List<String> list) {
        if (index == s.length()) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String subStr = s.substring(index, i + 1);
            if (isPalindrome(subStr)) {
                list.add(subStr);
                nextWords(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}