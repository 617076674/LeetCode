package question0821_shortest_distance_to_a_character;

/**
 * 顺序逆序两次扫描。
 *
 * 第一次顺序扫描，用prev指针记录每个字符离最近的左侧字符C的距离。
 * 第二次逆序扫描，用prev指针记录每个字符离最近的右侧字符C的距离。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串S的长度。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：36.4MB，击败83.19%。
 */
public class Solution2 {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] result = new int[n];
        int prev = -n;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) {
                prev = i;
            }
            result[i] = i - prev;
        }
        prev = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                prev = i;
            }
            result[i] = Math.min(prev - i, result[i]);
        }
        return result;
    }
}
