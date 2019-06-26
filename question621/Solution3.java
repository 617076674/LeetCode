package question621;


import java.util.Arrays;

public class Solution3 {

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }
        Arrays.sort(count);
        int maxVal = count[25] - 1, idleSlots = maxVal * n;
        for (int i = 24; i >= 0 && count[i] > 0; i--) {
            idleSlots -= Math.min(count[i], maxVal);
        }
        if (idleSlots > 0) {
            return idleSlots + tasks.length;
        } else {
            return tasks.length;
        }
    }

}
