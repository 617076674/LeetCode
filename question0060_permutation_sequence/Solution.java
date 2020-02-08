package question0060_permutation_sequence;

/**
 * https://leetcode-cn.com/problems/permutation-sequence/
 *
 * 对数组{1, 2, 3, ..., n}进行重新排列。
 *
 * 以n = 4, k = 14的情况来举例说明。
 *
 * 1 + {2, 3, 4}          6
 * 2 + {1, 3, 4}          6
 * 3 + {1, 2, 4}          6
 * 4 + {1, 2, 3}          6
 *
 * 由上述可知，由1开头的排列有6个，由2开头的排列、由3开头的排列、由4开头的排列也均有6个。当我们寻找第14个排列时，
 * 势必可以确定第一个数字是3。然后我们将在{1, 2, 4}中寻找第2个排列。
 *
 * 1 + {2, 4}          2
 * 2 + {1, 4}          2
 * 4 + {1, 2}          2
 *
 * 由上述可知，由1开头的排列有2个，由2开头的排列、由4开头的排列也均有2个。当我们寻找第2个排列时，势必可以确定第二个数字是1。
 * 然后我们将在{2, 4}中寻找第2个排列。
 *
 * 2 + {4}          1
 * 4 + {2}          1
 *
 * 由上述可知，由2开头的排列有1个，由4开头的排列也有1个。当我们寻找第2个排列时，势必可以确定第三个数字是4。然后我们将在{2}中寻找第1个排列。
 *
 * 由于{2}中只有一个数字，其第一个排列，即第四个数字必定是2。
 *
 * 到此，我们求出n = 4, k = 14的情况的结果是3142。
 *
 * 我们将上述这整一个过程用递归的形式写出来即可。
 *
 * 时间复杂度和空间复杂度均是O(n)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：34.1MB，击败93.47%。
 */
public class Solution {
    public String getPermutation(int n, int k) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        getPermutation(array, 0, k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }

    private void getPermutation(int[] array, int index, int k) {
        if (k == 1) {
            return;
        }
        int i = index, level = factorial(array.length - index - 1);
        for (; i < array.length; i++) {
            if (k - level < 1) {
                break;
            }
            k -= level;
        }
        int tmp = array[i];
        for (int j = i - 1; j >= index; j--) {
            array[j + 1] = array[j];
        }
        array[index] = tmp;
        getPermutation(array, index + 1, k);
    }

    private int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}