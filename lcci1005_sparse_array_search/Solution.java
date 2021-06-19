package lcci1005_sparse_array_search;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int findString(String[] words, String s) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                indexes.add(i);
            }
        }
        int left = 0, right = indexes.size() - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (words[indexes.get(mid)].equals(s)) {
                return indexes.get(mid);
            } else if (words[indexes.get(mid)].compareTo(s) < 0) {
                left++;
            } else {
                right--;
            }
        }
        return -1;
    }

}