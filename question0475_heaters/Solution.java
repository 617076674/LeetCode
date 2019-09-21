package question0475_heaters;

import java.util.Arrays;

/**
 * 二分查找法。
 *
 * 时间复杂度是O(n1 * log(n2))，其中n1为houses的长度，n2为heaters的长度。空间复杂度是O(1)。
 *
 * 执行用时：19ms，击败88.27%。消耗内存：39.2MB，击败97.24%。
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int result = 0;
        Arrays.sort(heaters);
        for (int i = 0; i < houses.length; i++) {
            result = Math.max(findClosestGap(houses[i], heaters), result);
        }
        return result;
    }

    private int findClosestGap(int house, int[] heaters) {
        int gap = Integer.MAX_VALUE, left = 0, right = heaters.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (heaters[mid] == house) {
                return 0;
            } else if (heaters[mid] < house) {
                gap = Math.min(gap, house - heaters[mid]);
                left = mid + 1;
            } else {
                gap = Math.min(gap, heaters[mid] - house);
                right = mid - 1;
            }
        }
        return Math.min(gap, Math.abs(house - heaters[left]));
    }
}
