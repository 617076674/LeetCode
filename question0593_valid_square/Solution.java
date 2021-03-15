package question0593_valid_square;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer, Integer> map = new HashMap<>();
        int d1 = calculateDistance(p1, p2);
        int d2 = calculateDistance(p1, p3);
        int d3 = calculateDistance(p1, p4);
        int d4 = calculateDistance(p2, p3);
        int d5 = calculateDistance(p2, p4);
        int d6 = calculateDistance(p3, p4);
        map.put(d1, map.getOrDefault(d1, 0) + 1);
        map.put(d2, map.getOrDefault(d2, 0) + 1);
        map.put(d3, map.getOrDefault(d3, 0) + 1);
        map.put(d4, map.getOrDefault(d4, 0) + 1);
        map.put(d5, map.getOrDefault(d5, 0) + 1);
        map.put(d6, map.getOrDefault(d6, 0) + 1);
        if (map.values().size() != 2) {
            return false;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            min = Math.min(min, key);
            max = Math.max(max, key);
        }
        if (max != min * 2) {
            return false;
        }
        return map.get(min) == map.get(max) * 2;
    }

    private static int calculateDistance(int[] p1, int[] p2) {
        return (int) (Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }

}