package question1003_check_if_word_is_valid_after_substitutions;

import java.util.LinkedList;

public class Solution {

    public boolean isValid(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'c') {
                if (linkedList.size() >= 2 && linkedList.get(linkedList.size() - 1) == 'b' && linkedList.get(linkedList.size() - 2) == 'a') {
                    linkedList.pollLast();
                    linkedList.pollLast();
                } else {
                    return false;
                }
            } else {
                linkedList.addLast(c);
            }
        }
        return linkedList.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("aabcbc"));
        System.out.println(new Solution().isValid("abcabcababcc"));
        System.out.println(new Solution().isValid("abccba"));
        System.out.println(new Solution().isValid("cababc"));
    }

}