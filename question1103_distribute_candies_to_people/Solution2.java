package question1103_distribute_candies_to_people;

/**
 * 找规律。
 *
 * 时间复杂度是O(num_people)。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：37MB，击败5.27%。
 */
public class Solution2 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int turns = (int) ((Math.sqrt(1 + 8 * (long) candies) - 1) / (2 * num_people)),
                remain = candies - (1 + turns * num_people) * turns * num_people / 2;
        for (int i = 0; i < num_people; i++) {
            int tmp = Math.min(remain, i + 1 + num_people * turns);
            result[i] = (i + 2 + (turns - 1) * num_people + i) * turns / 2 + tmp;
            remain -= tmp;
        }
        return result;
    }
}