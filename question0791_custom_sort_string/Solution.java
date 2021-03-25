package question0791_custom_sort_string;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String customSortString(String S, String T) {
        int[] map = new int[26];
        Arrays.fill(map, Integer.MAX_VALUE);
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        Character[] tArray = new Character[T.length()];
        for (int i = 0; i < T.length(); i++) {
            tArray[i] = T.charAt(i);
        }
        Arrays.sort(tArray, Comparator.comparingInt(c -> map[c - 'a']));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tArray.length; i++) {
            sb.append(tArray[i]);
        }
        return sb.toString();
    }
}