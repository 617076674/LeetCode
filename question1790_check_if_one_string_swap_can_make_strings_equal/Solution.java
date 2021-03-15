package question1790_check_if_one_string_swap_can_make_strings_equal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        Set<Integer> diffSet = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffSet.add(i);
            }
        }
        if (diffSet.isEmpty()) {
            return true;
        }
        if (diffSet.size() != 2) {
            return false;
        }
        List<Integer> list = new ArrayList<>(diffSet);
        int index1 = list.get(0), index2 = list.get(1);
        return s1.charAt(index1) == s2.charAt(index2) && s1.charAt(index2) == s2.charAt(index1);
    }
}