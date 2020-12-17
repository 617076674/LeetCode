package question0134_gas_station;

/**
 * 一次遍历解决。
 *
 * 时间复杂度是O(n)，其中n为站点数。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败98.83%。消耗内存：38.5MB，击败40.63%。
 */
public class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;  //gas所有元素和-cost所有元素和
        int sum = 0;    //从start位置开始，gas中元素和-cost中元素和
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = gas[i] - cost[i];
                start = i;
            } else {
                sum += gas[i] - cost[i];
            }
        }
        return total < 0 ? -1 : start;
    }
}