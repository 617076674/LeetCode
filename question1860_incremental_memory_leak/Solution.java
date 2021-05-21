package question1860_incremental_memory_leak;

import java.util.Arrays;

public class Solution {

    public int[] memLeak(int memory1, int memory2) {
        int time = 1;
        while (true) {
            if (memory1 < memory2) {
                // 分配给 memory2
                if (memory2 < time) {
                    return new int[] {time, memory1, memory2};
                }
                memory2 -= time;
            } else {
                // 分配给 memory1
                if (memory1 < time) {
                    return new int[] {time, memory1, memory2};
                }
                memory1 -= time;
            }
            time++;
        }
    }

}