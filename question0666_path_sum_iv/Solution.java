package question0666_path_sum_iv;

import java.util.Arrays;

/**
 * 按堆的存储方法，用数组来存储数据。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：34.4MB，击败100.00%。
 */
public class Solution {
    private int sum;

    private int[] tree = new int[63];

    public int pathSum(int[] nums) {
        Arrays.fill(tree, -1);
        for (int num : nums) {
            tree[calculateIndex(num)] = num % 10;
        }
        dfs(0, 0);
        return sum;
    }

    private void dfs(int index, int path) {
        int left = leftChild(index), right = rightChild(index);
        if (tree[left] == -1 && tree[right] == -1) {
            sum += path + tree[index];
            return;
        }
        if (tree[left] != -1) {
            dfs(left, path + tree[index]);
        }
        if (tree[right] != -1) {
            dfs(rightChild(index), path + tree[index]);
        }
    }

    private int leftChild(int index) {
        return (index << 1) + 1;
    }

    private int rightChild(int index) {
        return (index << 1) + 2;
    }

    private int calculateIndex(int num) {
        int level = num / 100, i = (num - level * 100) / 10;
        return (int) (Math.pow(2, level - 1) + i - 2);
    }
}