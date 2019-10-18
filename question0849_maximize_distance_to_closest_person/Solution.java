package question0849_maximize_distance_to_closest_person;

/**
 * 分别用两个数组left和right记录每个位置上的0离最左侧1的最近距离和最右侧1的最近距离，注意对边界0的处理。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为seats数组的长度。
 *
 * 执行用时：4ms，击败73.88%。消耗内存：38.9MB，击败93.75%。
 */
public class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] left = new int[n];
        int pre = Integer.MIN_VALUE / 2;    //防止减法越界
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                pre = i;
            } else {
                left[i] = i - pre;
            }
        }
        int[] right = new int[n];
        pre = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                pre = i;
            } else {
                right[i] = pre - i;
            }
        }
        int index = 0, distance = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                int tmp = Math.min(left[i], right[i]);
                if (tmp > distance) {
                    distance = tmp;
                    index = i;
                }
            }
        }
        return distance;
    }
}
