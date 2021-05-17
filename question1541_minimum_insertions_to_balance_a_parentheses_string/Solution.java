package question1541_minimum_insertions_to_balance_a_parentheses_string;

import java.util.LinkedList;

public class Solution {

    public int minInsertions(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (c == '(') {
                linkedList.addLast(c);
                i++;
            } else {
                if (linkedList.isEmpty() || linkedList.peekLast() != '(') {
                    linkedList.addLast('(');
                    result++;
                }
                if (i + 1 >= s.length() || s.charAt(i + 1) != ')') {
                    result++;
                    i--;
                }
                linkedList.pollLast();
                i += 2;
            }
        }
        result += linkedList.size() * 2;
        return result;
    }

}