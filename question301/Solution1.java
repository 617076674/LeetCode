package question301;


import java.util.*;

public class Solution1 {

    private Set<String> set;

    private String input;

    private int maxLen = 0;

    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet<>();
        input = s;
        removeInvalidParentheses(0, "", new LinkedList<>());
        return new ArrayList<>(set);
    }

    private void removeInvalidParentheses(int index, String valid, LinkedList<Character> linkedList) {
        if (index == input.length()) {
            if (linkedList.isEmpty()) {
                if (maxLen < valid.length()) {
                    maxLen = valid.length();
                    set.clear();
                    set.add(valid);
                } else if (maxLen == valid.length()) {
                    set.add(valid);
                }
            }
            return;
        }
        char c = input.charAt(index);
        if (c == '(') {
            removeInvalidParentheses(index + 1, valid, new LinkedList<>(linkedList));
            linkedList.push(c);
            removeInvalidParentheses(index + 1, valid + c, linkedList);
        } else if (c == ')') {
            if (linkedList.isEmpty()) {
                removeInvalidParentheses(index + 1, valid, linkedList);
            } else {
                removeInvalidParentheses(index + 1, valid, new LinkedList<>(linkedList));
                linkedList.pop();
                removeInvalidParentheses(index + 1, valid + c, linkedList);
            }
        } else {
            removeInvalidParentheses(index + 1, valid + c, linkedList);
        }
    }

}
