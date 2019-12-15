package question0288_unique_word_abbreviation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 哈希表。
 *
 * 1-单词的缩写是否在字典中出现过？如果没有，它就是唯一的。
 * 2-如果上述答案是出现过，它是唯一的条件是这个组里除了它本身word以外没有其他任何单词。
 *
 * 执行用时：66ms，击败100.00%。消耗内存：53.1MB，击败100.00%。
 */
public class ValidWordAbbr {
    private Map<String, Set<String>> abbrDict = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String s : dictionary) {
            String abbr = tranform(s);
            Set<String> words = abbrDict.containsKey(abbr) ? abbrDict.get(abbr) : new HashSet<>();
            words.add(s);
            abbrDict.put(abbr, words);
        }
    }

    public boolean isUnique(String word) {
        String abbr = tranform(word);
        Set<String> words = abbrDict.get(abbr);
        return words == null || (words.size() == 1 && words.contains(word));
    }

    private String tranform(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
    }
}