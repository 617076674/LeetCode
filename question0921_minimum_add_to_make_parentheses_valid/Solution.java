package question0921_minimum_add_to_make_parentheses_valid;

import java.util.LinkedList;

public class Solution {
    public int minAddToMakeValid(String S) {
        int result = 0;
        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                linkedList.addLast(c);
            } else {
                if (linkedList.isEmpty()) {
                    result++;
                } else {
                    linkedList.pollLast();
                }
            }
        }
        return result + linkedList.size();
    }
}