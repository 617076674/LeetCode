package question2002_maximum_product_of_the_length_of_two_palindromic_subsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    private int result;

    public int maxProduct(String s) {
        getAllS(s, 0, new ArrayList<>());
        return result;
    }

    private void getAllS(String s, int index, List<Integer> list) {
        if (index == s.length()) {
            if (check(list, s)) {
                if (!list.isEmpty() && list.size() != s.length()) {
                    getAllS(s, 0, new HashSet<>(list), new ArrayList<>());
                }
            }
            return;
        }
        getAllS(s, index + 1, list);
        list.add(index);
        getAllS(s, index + 1, list);
        list.remove(list.size() - 1);
    }

    private boolean check(List<Integer> list, String s) {
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (s.charAt(list.get(i)) != s.charAt(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private void getAllS(String s, int index, Set<Integer> set, List<Integer> list) {
        if (index == s.length()) {
            if (check(list, s)) {
                result = Math.max(result, set.size() * list.size());
            }
            return;
        }
        getAllS(s, index + 1, set, list);
        if (set.contains(index)) {
            return;
        }
        list.add(index);
        getAllS(s, index + 1, set, list);
        list.remove(list.size() - 1);
    }

}