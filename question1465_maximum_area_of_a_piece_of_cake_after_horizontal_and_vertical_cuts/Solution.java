package question1465_maximum_area_of_a_piece_of_cake_after_horizontal_and_vertical_cuts;

import java.util.Arrays;

public class Solution {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int rows = maxGap(h, horizontalCuts), cols = maxGap(w, verticalCuts);
        return (int) (((long) rows) * cols % 1000000007);
    }

    private static int maxGap(int end, int[] lines) {
        int result = lines[0];
        for (int i = 1; i < lines.length; i++) {
            result = Math.max(result, lines[i] - lines[i - 1]);
        }
        return Math.max(result, end - lines[lines.length - 1]);
    }

}