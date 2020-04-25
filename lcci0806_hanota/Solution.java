package lcci0806_hanota;

import java.util.List;

/**
 * 执行用时：1ms，击败87.44%。消耗内存：37.8MB，击败100.00%。
 */
public class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(), A, B, C);
    }

    //A中有n个盘子，借助B，将其移动到C上
    private void hanota(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        //如果A只剩一个盘子，那么直接移动到C柱子即可
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        //把A上的n-1个盘子，借助C，放到B上
        hanota(n - 1, A, C, B);
        //此时A剩下那个盘子是最大的那个，把他移动到C上
        C.add(A.remove(A.size() - 1));
        //最后把刚才放在B上的n-1个盘子，借助A，移动到C上
        hanota(n - 1, B, A, C);
    }
}