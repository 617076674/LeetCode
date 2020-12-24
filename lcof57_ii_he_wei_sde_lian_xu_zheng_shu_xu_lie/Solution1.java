package lcof57_ii_he_wei_sde_lian_xu_zheng_shu_xu_lie;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> listList = new ArrayList<>();
        int start = 1;
        while (start <= (target - 1) / 2) {
            int x = getX(start, target);
            if (Double.compare(x * (2 * start + x - 1) / 2, target) == 0) {
                List<Integer> list = new ArrayList<>();
                for (int i = start; i <= start + x - 1; i++) {
                    list.add(i);
                }
                listList.add(list);
            }
            start++;
        }
        int[][] result = new int[listList.size()][];
        for (int i = 0; i < listList.size(); i++) {
            result[i] = new int[listList.get(i).size()];
            for (int j = 0; j < listList.get(i).size(); j++) {
                result[i][j] = listList.get(i).get(j);
            }
        }
        return result;
    }
    
    private int getX(double start, double target) {
        return (int) ((1 - 2 * start + Math.sqrt(Math.pow(2 * start - 1, 2) + 8 * target)) / 2);
    }
    
}