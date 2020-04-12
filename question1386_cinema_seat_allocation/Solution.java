package question1386_cinema_seat_allocation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 时间复杂度是O(mlogm)，其中m为reservedSeats数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：58ms，击败26.07%。消耗内存：46MB，击败100.00%。
 */
public class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int result = 0;
        Integer[][] tmp = new Integer[reservedSeats.length][2];
        for (int i = 0; i < reservedSeats.length; i++) {
            tmp[i][0] = reservedSeats[i][0];
            tmp[i][1] = reservedSeats[i][1];
        }
        Arrays.sort(reservedSeats, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int[] row = new int[10];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            Arrays.fill(row, 0);
            int j = i;
            row[reservedSeats[i][1] - 1] = 1;
            set.add(reservedSeats[i][0]);
            while (j + 1 < reservedSeats.length && reservedSeats[j + 1][0] == reservedSeats[i][0]) {
                row[reservedSeats[++j][1] - 1] = 1;
            }
            result += count(row);
            i = j;
        }
        result += ((n - set.size()) << 1);
        return result;
    }

    private int count(int[] row) {
        int sum = 0;
        for (int i = 1; i <= 8; i++) {
            sum += row[i];
        }
        if (sum == 0) {
            return 2;
        }
        sum = 0;
        for (int i = 1; i <= 4; i++) {
            sum += row[i];
        }
        if (sum == 0) {
            return 1;
        }
        sum = 0;
        for (int i = 3; i <= 6; i++) {
            sum += row[i];
        }
        if (sum == 0) {
            return 1;
        }
        sum = 0;
        for (int i = 5; i <= 8; i++) {
            sum += row[i];
        }
        if (sum == 0) {
            return 1;
        }
        return 0;
    }
}