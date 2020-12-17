package question0134_gas_station;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n为站点数。空间复杂度是O(1)。
 *
 * 执行用时：133ms，击败16.99%。消耗内存：39.3MB，击败28.13%。
 */
public class Solution1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = -1;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                int sum = 0;
                int j = 0;
                for (; j < gas.length; j++) {
                    sum += gas[(i + j) % gas.length] - cost[(i + j) % gas.length];
                    if (sum < 0) {
                        break;
                    }
                }
                if (j >= gas.length) {
                    start = i;
                    break;
                }
            }
        }
        return start;
    }
}