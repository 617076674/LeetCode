package question076;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81427851
 */

import java.util.HashMap;

public class Solution {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (hashMap.containsKey(t.charAt(i))) {
                hashMap.put(t.charAt(i), hashMap.get(t.charAt(i)) + 1);
            } else {
                hashMap.put(t.charAt(i), 1);
            }
        }
        int left = 0;
        int right = -1;
        int count = 0;  //[left, right] contains count characters in t
        String result = "";
        int len = s.length() + 1;
        while (left < s.length()) {
            if (right + 1 < s.length() && count < t.length()) {
                right++;
                if (hashMap.containsKey(s.charAt(right))) {
                    if (hashMap.get(s.charAt(right)) > 0) {
                        count++;
                    }
                    hashMap.put(s.charAt(right), hashMap.get(s.charAt(right)) - 1);
                }
            } else {
                if (hashMap.containsKey(s.charAt(left))) {
                    if (hashMap.get(s.charAt(left)) == 0) {
                        count--;
                    }
                    hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) + 1);
                }
                left++;
            }
            if (count == t.length()) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    result = s.substring(left, right + 1);
                }
            }
        }
        return result;
    }
}
