package question0187_repeated_dna_sequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String temp = s.substring(i, i + 10);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (String string : map.keySet()) {
            if (map.get(string) > 1) {
                list.add(string);
            }
        }
        return list;
    }

}