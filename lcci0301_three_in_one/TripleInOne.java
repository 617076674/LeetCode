package lcci0301_three_in_one;

/**
 * https://leetcode-cn.com/problems/three-in-one-lcci/
 *
 * 执行用时：12ms，击败99.73%。消耗内存：48.9MB，击败100.00%。
 */
public class TripleInOne {
    private int[] nums, curs;

    public TripleInOne(int stackSize) {
        nums = new int[3 * stackSize];
        curs = new int[] {0, stackSize, 2 * stackSize};
    }

    public void push(int stackNum, int value) {
        if (curs[stackNum] == (stackNum + 1) * nums.length / 3) {
            return;
        }
        nums[curs[stackNum]++] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        return nums[--curs[stackNum]];
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        return nums[curs[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return curs[stackNum] == stackNum * nums.length / 3;
    }
}