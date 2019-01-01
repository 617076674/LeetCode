package question134;

public class Solution1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = -1;
        for(int i = 0; i < gas.length; i++){
            if(gas[i] >= cost[i]){
                int sum = 0;
                int j = 0;
                for(; j < gas.length; j++){
                    sum += gas[(i + j) % gas.length] - cost[(i + j) % gas.length];
                    if(sum < 0){
                        break;
                    }
                }
                if(j >= gas.length){
                    start = i;
                    break;
                }
            }
        }
        return start;
    }
}