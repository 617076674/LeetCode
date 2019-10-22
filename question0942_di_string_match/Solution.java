package question0942_di_string_match;

/**
 * 首先初始化数组为升序排列。
 *
 * 当遇到一段连续的D（可以是1个D）时，反转这段D对应索引的数组中的元素即可。
 *
 * 时间复杂度是O(n)，其中n为字符串S的长度。空间复杂度是O(1)。
 */
public class Solution {
    public int[] diStringMatch(String S) {
        int n = S.length();
        int[] result = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            result[i] = i;
        }
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'D') {
                int j = i;
                while (j + 1 < n && S.charAt(j + 1) == 'D') {
                    j++;
                }
                reverse(result, i, j + 1);
                i = j;
            }
        }
        return result;
    }

    private void reverse(int[] nums, int i, int j) {
        for (int k = i; k <= i + ((j - i) >> 1); k++) {
            swap(nums, k, j + i - k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
