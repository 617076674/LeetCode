package question1024_video_stitching;

import java.util.Arrays;

/**
 * 先对区间进行排序，比较原则为先比较每个区间的起点，再比较每个区间的终点。
 *
 * 依次遍历排序后的每个区间，取满足条件的终点最大的那个区间作为选取的下一个区间。如果在遍历过程中无法找到下一个满足条件的区间，返回 -1。
 *
 * 时间复杂度是 O(logn)，其中 n 为 clips 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败74.47%。消耗内存：37.3MB，击败100.00%。
 */
public class Solution {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (clip1, clip2) -> {
            if (clip1[0] == clip2[0]) {
                return clip1[1] - clip2[1];
            }
            return clip1[0] - clip2[0];
        });
        if (clips.length == 0 || clips[0][0] != 0 || clips[clips.length - 1][1] < T) {
            return -1;
        }
        int end = 0, result = 0;
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] <= end) {
                int candidate = i, j = i;
                while (j + 1 < clips.length && clips[j + 1][0] <= end) {
                    if (clips[j + 1][1] > clips[candidate][1]) {
                        candidate = j + 1;
                    }
                    j++;
                }
                result++;
                if (clips[candidate][1] >= T) {
                    return result;
                }
                i = j;
                end = clips[candidate][1];
            } else {
                return -1;
            }
        }
        return result;
    }
}