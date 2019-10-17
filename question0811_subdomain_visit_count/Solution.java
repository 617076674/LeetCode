package question0811_subdomain_visit_count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 执行用时：14ms，击败97.57%。消耗内存：38.5MB，击败98.36%。
 */
public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] strings = s.split(" ");
            int count = Integer.parseInt(strings[0]);
            while (true) {
                addToMap(map, strings[1], count);
                int index = strings[1].indexOf('.');
                if (index == -1) {
                    break;
                }
                strings[1] = strings[1].substring(index + 1);
            }
        }
        List<String> result = new ArrayList<>();
        for (String s : map.keySet()) {
            result.add(map.get(s) + " " + s);
        }
        return result;
    }

    private void addToMap(Map<String, Integer> map, String s, int count) {
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + count);
        } else {
            map.put(s, count);
        }
    }
}
