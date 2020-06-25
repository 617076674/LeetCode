package question0982_triples_with_bitwise_and_equal_to_zero;

/**
 * 哈希表。
 *
 * 时间复杂度是 O(max(n ^ 2, n * (2 ^ 16)))。空间复杂度是 O(2 ^ 16)。
 *
 * 执行用时：61ms，击败84.15%。消耗内存：39.7MB，击败66.67%。
 */
public class Solution1 {
    public int countTriplets(int[] A) {
        int[] map = new int[1 << 16];
        for (int num1 : A) {
            for (int num2 : A) {
                map[num1 & num2]++;
            }
        }
        int result = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                for (int num3 : A) {
                    if ((i & num3) == 0) {
                        result += map[i];
                    }
                }
            }
        }
        return result;
    }
}
