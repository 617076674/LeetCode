package contest12_27.question1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean halvesAreAlike(String s) {
        Map<Character, Integer> character2Index = new HashMap<>();
        character2Index.put('a', 0);
        character2Index.put('e', 1);
        character2Index.put('i', 2);
        character2Index.put('o', 3);
        character2Index.put('u', 4);
        character2Index.put('A', 5);
        character2Index.put('E', 6);
        character2Index.put('I', 7);
        character2Index.put('O', 8);
        character2Index.put('U', 9);
        int count1 = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            Integer index = character2Index.get(s.charAt(i));
            if (null != index) {
                count1++;
            }
        }
        int count2 = 0;
        for (int i = s.length() / 2; i < s.length(); i++) {
            Integer index = character2Index.get(s.charAt(i));
            if (null != index) {
                count2++;
            }
        }
        return count1 == count2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().halvesAreAlike("book"));
        System.out.println(new Solution().halvesAreAlike("textbook"));
        System.out.println(new Solution().halvesAreAlike("MerryChristmas"));
        System.out.println(new Solution().halvesAreAlike("AbCdEfGh"));
    }
}