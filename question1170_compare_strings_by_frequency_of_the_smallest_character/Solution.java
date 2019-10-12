package question1170_compare_strings_by_frequency_of_the_smallest_character;

import java.util.Arrays;

/**
 * 二分查找法。
 *
 * 时间复杂度是O(max(n1, n2 * log(n2))，其中n1为queries数组的长度，n2为words数组的长度。空间复杂度是O(n2)。
 *
 * 执行用时：3ms，击败97.41%。消耗内存：37.9MB，击败100.00%。
 */
public class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n1 = queries.length, n2 = words.length;
        int[] fWords = new int[n2];
        for (int i = 0; i < n2; i++) {
            fWords[i] = f(words[i]);
        }
        Arrays.sort(fWords);
        int[] result = new int[n1];
        for (int i = 0; i < n1; i++) {
            result[i] = n2 - ceil(fWords, f(queries[i]));
        }
        return result;
    }

    private int f(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return map[i];
            }
        }
        return -1;
    }

    private int ceil(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
