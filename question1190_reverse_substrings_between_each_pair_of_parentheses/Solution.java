package question1190_reverse_substrings_between_each_pair_of_parentheses;

import java.util.LinkedList;

public class Solution {

    public String reverseParentheses(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                LinkedList<Character> temp = new LinkedList<>();
                while (linkedList.peekLast() != '(') {
                    temp.addLast(linkedList.pollLast());
                }
                linkedList.pollLast();
                while (!temp.isEmpty()) {
                    linkedList.addLast(temp.pollFirst());
                }
            } else {
                linkedList.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!linkedList.isEmpty()) {
            sb.append(linkedList.pollFirst());
        }
        return sb.toString();
    }

}