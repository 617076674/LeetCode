package question1055_shortest_way_to_form_string;

/**
 * 时间复杂度是 O(n1 * n2)，其中 n1 是字符串 source 的长度，n2 是字符串 target 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：4ms，击败81.82%。消耗内存：37.3MB，击败100.00%。
 */
public class Solution {
    public int shortestWay(String source, String target) {
        int result = 0, n1 = source.length(), n2 = target.length(), index1 = 0, index2 = 0;
        while (index2 < n2) {
            int i = 0;
            while (i < n1) {
                if ((index1 + i) % n1 == 0) {
                    result++;
                }
                if (source.charAt((index1 + i) % n1) == target.charAt(index2)) {
                    break;
                }
                i++;
            }
            if (i == n1) {
                return -1;
            }
            index1 = (i + index1 + 1) % n1;
            index2++;
        }
        return result;
    }
}