package question1128_number_of_equivalent_domino_pairs;

/**
 * 哈希表。
 *
 * 时间复杂度是O(n)，其中n为dominoes数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败99.82%。消耗内存：55.1MB，击败100.00%。
 */
public class Solution2 {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] map = new int[100];
        for (int i = 0; i < dominoes.length; i++) {
            int index;
            if (dominoes[i][0] <= dominoes[i][1]) {
                index = dominoes[i][0] * 10 + dominoes[i][1];
            } else {
                index = dominoes[i][1] * 10 + dominoes[i][0];
            }
            map[index]++;
        }
        int result = 0;
        for (int num : map) {
            result += (num * (num - 1)) >> 1;
        }
        return result;
    }

}