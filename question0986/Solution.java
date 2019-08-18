package question0986;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-08-18
 *
 * 双指针，注意对A或B数组长度为0时做特殊处理。
 *
 * 时间复杂度是O(n1 + n2)，其中n1为数组A的长度，n2为数组B的长度。空间复杂度是O(1)。
 *
 * 执行用时：11ms，击败30.09%。消耗内存：60.3MB，击败7.02%。
 */
public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        int index1 = 0, index2 = 0;
        int n1 = A.length, n2 = B.length;
        if (n1 * n2 == 0) {
            return new int[0][2];
        }
        while (true) {
            int left = Math.max(A[index1][0], B[index2][0]), right = Math.min(A[index1][1], B[index2][1]);
            if (left <= right) {
                list.add(new Pair<>(left, right));
            }
            if (index1 == n1 - 1 && index2 == n2 - 1) { //如果所有的区间都已经遍历完毕
                break;
            }
            if (index1 == n1 - 1) { //A区间已经遍历结束
                index2++;
            } else if (index2 == n2 - 1) {  //B区间已经遍历结束
                index1++;
            } else {
                //A区间和B区间均没有遍历结束
                if (A[index1][1] < B[index2][1]) {
                    index1++;
                } else {
                    index2++;
                }
            }
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = list.get(i).getKey();
            result[i][1] = list.get(i).getValue();
        }
        return result;
    }
}
