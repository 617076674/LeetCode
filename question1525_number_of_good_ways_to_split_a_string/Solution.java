package question1525_number_of_good_ways_to_split_a_string;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numSplits(String s) {
        Map<Character, Integer> leftMap = new HashMap<>(), rightMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            rightMap.put(c, rightMap.getOrDefault(c, 0) + 1);
        }
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            leftMap.put(c, leftMap.getOrDefault(c, 0) + 1);
            if (rightMap.get(c) == 1) {
                rightMap.remove(c);
            } else {
                rightMap.put(c, rightMap.get(c) - 1);
            }
            if (leftMap.size() == rightMap.size()) {
                result++;
            }
        }
        return result;
    }

}