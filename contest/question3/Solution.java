package contest.question3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < "croak".length(); i++) {
            map.put("croak".charAt(i), 0);
        }
        int result = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            if (c == 'c') {
                if (map.get('c') == 0) {
                    result++;
                } else {
                    map.put('c', map.get('c') - 1);
                }
                map.put('r', map.get('r') + 1);
            } else if (c == 'r') {
                if (map.get('r') == 0) {
                    result++;
                } else {
                    map.put('r', map.get('r') - 1);
                }
                map.put('o', map.get('o') + 1);
            } else if (c == 'o') {
                if (map.get('o') == 0) {
                    result++;
                } else {
                    map.put('o', map.get('o') - 1);
                }
                map.put('a', map.get('a') + 1);
            } else if (c == 'a') {
                if (map.get('a') == 0) {
                    result++;
                } else {
                    map.put('a', map.get('a') - 1);
                }
                map.put('k', map.get('k') + 1);
            } else if (c == 'k') {
                if (map.get('k') == 0) {
                    result++;
                } else {
                    map.put('k', map.get('k') - 1);
                }
                map.put('c', map.get('c') + 1);
            } else {
                return -1;
            }
        }
        for (char c : map.keySet())  {
            if (c != 'c' && map.get(c) != 0) {
                return -1;
            }
        }
        return result;
    }
}