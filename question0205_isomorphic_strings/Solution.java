package question0205_isomorphic_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> visited = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            Character tmp = map.get(c1);
            if (null == tmp) {
                if (visited.contains(c2)) {
                    return false;
                }
                map.put(c1, c2);
                visited.add(c2);
            } else if (tmp != c2) {
                return false;
            }
        }
        return true;
    }

}
