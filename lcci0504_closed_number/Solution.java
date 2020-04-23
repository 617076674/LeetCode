package lcci0504_closed_number;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：36.9MB，击败100.00%。
 */
public class Solution {
    public int[] findClosedNumbers(int num) {
        return new int[] {getBigger(num), getSmaller(num)};
    }

    private int getSmaller(int num) {
        int index = 0, count1 = 0;
        boolean flag = false;
        while (index < 32) {
            if ((num & (1 << index)) != 0) {
                if (flag) {
                    break;
                }
                count1++;
            } else {
                flag = true;
            }
            index++;
        }
        num ^= (1 << index);
        num |= ((1 << index) - 1);
        num &= -(1 << (index - count1 - 1));
        if (num <= 0) {
            return -1;
        }
        return num;
    }

    private int getBigger(int num) {
        int index = 0, count0 = 0;
        boolean flag = false;
        while (index < 32) {
            if ((num & (1 << index)) == 0) {
                if (flag) {
                    break;
                }
                count0++;
            } else {
                flag = true;
            }
            index++;
        }
        num |= (1 << index);
        num &= -(1 << index);
        num |= ((1 << (index - count0 - 1)) - 1);
        if (num <= 0) {
            return -1;
        }
        return num;
    }
}