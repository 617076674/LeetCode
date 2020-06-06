package question0517_super_washing_machines;

/**
 * 最终结果数组中每个位置上的元素值都应该是 average。
 *
 * 时间复杂度是 O(n)，其中 n 为 machines 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：40.3MB，击败50.00%。
 */
public class Solution1 {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % machines.length != 0) {
            return -1;
        }
        int average = sum / machines.length;
        for (int i = 0; i < machines.length; i++) {
            machines[i] -= average;
        }
        int result = 0, preFixSum = 0;
        for (int machine : machines) {
            preFixSum += machine;
            result = Math.max(result, Math.max(machine, Math.abs(preFixSum)));
        }
        return result;
    }
}