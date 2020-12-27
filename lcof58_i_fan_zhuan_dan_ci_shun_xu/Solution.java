package lcof58_i_fan_zhuan_dan_ci_shun_xu;

import java.util.LinkedList;

public class Solution {

    public String reverseWords(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        LinkedList<String> stack = new LinkedList<>();
        int left = 0;
        while (left < s.length() && s.charAt(left) == ' ') {
            left++;
        }
        for (int right = left; right < s.length(); ) {
            if (s.charAt(right) == ' ') {
                stack.push(s.substring(left, right));
                left = right;
                while (left < s.length() && s.charAt(left) == ' ') {
                    left++;
                }
                right = left;
            } else {
                right++;
            }
        }
        if (s.charAt(s.length() - 1) != ' ') {
            stack.push(s.substring(left));
        }
        if (stack.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}