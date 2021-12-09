package question1964;

import java.util.Arrays;

public class Solution {

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] result = new int[n];
        int[] tops = new int[n];    // 每堆扑克牌堆顶的牌
        tops[0] = obstacles[0];  // 第一张牌显然只能新建一堆
        result[0] = 1;
        int piles = 1;  // 现在一共有piles堆扑克牌
        for (int i = 1; i < n; i++) {
            // 在[0, piles - 1]范围内寻找第一处比nums[i]大的位置，即ceil函数
            int left = 0, right = piles - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (tops[mid] == obstacles[i]) {
                    left = mid + 1;
                } else if (tops[mid] < obstacles[i]) {
                    left = mid + 1;
                } else if (tops[mid] > obstacles[i]) {
                    right = mid - 1;
                }
            }
            if (left == piles) {
                piles++;
            }
            tops[left] = obstacles[i];
            result[i] = left + 1;
        }
        return result;
    }

}