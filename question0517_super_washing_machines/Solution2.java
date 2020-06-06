package question0517_super_washing_machines;

public class Solution2 {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % machines.length != 0) {
            return -1;
        }
        int average = sum / machines.length, result = 0, preFixSum = 0;
        for (int i = 0; i < machines.length; i++) {
            int leftNeed = average * i - preFixSum, rightNeed = average * (machines.length - i - 1) - (sum - preFixSum - machines[i]);
            if (leftNeed > 0 && rightNeed > 0) {
                result = Math.max(result, leftNeed + rightNeed);
            } else {
                result = Math.max(result, Math.max(-leftNeed, -rightNeed));
            }
            preFixSum += machines[i];
        }
        return result;
    }
}
