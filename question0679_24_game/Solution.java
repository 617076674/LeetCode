package question0679_24_game;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力破解法。
 *
 * 每次从中挑选 2 个数进行加减乘除运算。
 *
 * 时间复杂度和空间复杂度均是 O(1)。
 *
 * 执行用时：7ms，击败40.63%。消耗内存：39.7MB，击败52.48%。
 */
public class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return judgePoint24Helper(list);
    }

    private boolean judgePoint24Helper(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) <= 0.000001;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    List<Double> tmpList = new ArrayList<>();
                    for (int k = 0; k < list.size(); k++) {
                        if (k != i && k != j) {
                            tmpList.add(list.get(k));
                        }
                    }
                    double num1 = list.get(i), num2 = list.get(j);
                    tmpList.add(num1 + num2);
                    if (judgePoint24Helper(tmpList)) {
                        return true;
                    }
                    tmpList.remove(tmpList.size() - 1);
                    tmpList.add(num1 * num2);
                    if (judgePoint24Helper(tmpList)) {
                        return true;
                    }
                    tmpList.remove(tmpList.size() - 1);
                    tmpList.add(num1 - num2);
                    if (judgePoint24Helper(tmpList)) {
                        return true;
                    }
                    tmpList.remove(tmpList.size() - 1);
                    if (Math.abs(num2) >= 0.000001) {
                        tmpList.add(num1 / num2);
                        if (judgePoint24Helper(tmpList)) {
                            return true;
                        }
                        tmpList.remove(tmpList.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}