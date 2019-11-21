package question1134_armstrong_number;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行用时：1ms，击败66.67%。消耗内存：32.7MB，击败100.00%。
 */
public class Solution {
    public boolean isArmstrong(int N) {
        List<Integer> list = new ArrayList<>();
        int backN = N;
        while (N > 0) {
            list.add(N % 10);
            N /= 10;
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += Math.pow(list.get(i), list.size());
        }
        return sum == backN;
    }
}