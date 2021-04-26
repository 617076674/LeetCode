package question1324_print_words_vertically;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> printVertically(String s) {
        List<StringBuilder> list = new ArrayList<>();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= list.size()) {
                    StringBuilder sb = new StringBuilder();
                    while (sb.length() < i) {
                        sb.append(" ");
                    }
                    sb.append(words[i].charAt(j));
                    list.add(sb);
                } else {
                    while (list.get(j).length() < i) {
                        list.get(j).append(" ");
                    }
                    list.get(j).append(words[i].charAt(j));
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (StringBuilder sb : list) {
            result.add(sb.toString());
        }
        return result;
    }

}