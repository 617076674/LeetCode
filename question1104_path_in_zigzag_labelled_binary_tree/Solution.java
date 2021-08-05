package question1104_path_in_zigzag_labelled_binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 假想一个数组来保存树中的节点值，和堆的思路很像，但一些区域需要反转。
 *
 * 时间复杂度和空间复杂度均是O(log(label))。
 *
 * 执行用时：2ms，击败46.00%。消耗内存：34.1MB，击败100.00%。
 */
public class Solution {

    public List<Integer> pathInZigZagTree(int label) {
        int row = 1, rowStart = 1;
        while (rowStart * 2 <= label) {
            row++;
            rowStart *= 2;
        }
        if (row % 2 == 0) {
            label = getReverse(label, row);
        }
        List<Integer> path = new ArrayList<>();
        while (row > 0) {
            if (row % 2 == 0) {
                path.add(getReverse(label, row));
            } else {
                path.add(label);
            }
            row--;
            label >>= 1;
        }
        Collections.reverse(path);
        return path;
    }

    public int getReverse(int label, int row) {
        return (1 << row - 1) + (1 << row) - 1 - label;
    }

}