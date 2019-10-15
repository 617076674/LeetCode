package question1103_distribute_candies_to_people;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(candies ^ 0.5)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败96.95%。消耗内存：33.7MB，击败100.00%。
 */
public class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int index = 1;
        for (int i = 0; ; i++) {
            if (candies <= index) {
                result[i % num_people] += candies;
                break;
            } else {
                result[i % num_people] += index;
                candies -= index;
                index++;
            }
        }
        return result;
    }
}
