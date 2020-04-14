package question1408_string_matching_in_an_array;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            boolean flag = false;
            for (int j = 0; j < words.length; j++) {
                if (j != i && words[j].contains(words[i])) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                result.add(words[i]);
            }
        }
        return result;
    }
}