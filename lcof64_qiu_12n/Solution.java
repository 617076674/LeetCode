package lcof64_qiu_12n;

/**
 * 短路与操作。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：1ms，击败66.05%。消耗内存：36.9MB，击败100.00%。
 */
public class Solution {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}