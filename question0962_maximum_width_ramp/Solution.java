package question0962_maximum_width_ramp;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int maxWidthRamp(int[] A) {
        Integer[] indexes = new Integer[A.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, Comparator.comparingInt(index -> A[index]));
        int result = 0, max = indexes[indexes.length - 1];
        for (int i = indexes.length - 2; i >= 0; i--) {
            result = Math.max(result, max - indexes[i]);
            max = Math.max(max, indexes[i]);
        }
        return result;
    }

}