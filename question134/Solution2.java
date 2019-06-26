package question134;

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
        if (total < 0) {
            return -1;
        }
        return start;
    }
}
