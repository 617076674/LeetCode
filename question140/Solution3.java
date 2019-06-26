package question140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Solution3 {
    HashMap<String, List<String>> hashMap = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (hashMap.containsKey(s)) {
            return hashMap.get(s);
        }
        List<String> list = new ArrayList<>();
        if (0 == s.length()) {
            list.add("");
            return list;
        }
        for (String str : wordDict) {
            if (s.startsWith(str)) {
                List<String> subList = wordBreak(s.substring(str.length()), wordDict);
                for (String sub : subList) {
                    list.add(str + (Objects.equals("", sub) ? "" : " ") + sub);
                }
            }
        }
        hashMap.put(s, list);
        return list;
    }
}