package question1095_find_in_mountain_array;

/**
 * 二分查找法。
 *
 * 时间复杂度是O(nlogn)，其中n为mountainArr的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.8MB，击败100.00%。
 */
public class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0, right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int peekIndex = left, result = binarySearch1(target, mountainArr, 0, peekIndex);
        if (result != -1) {
            return result;
        }
        return binarySearch2(target, mountainArr, peekIndex + 1, mountainArr.length() - 1);
    }

    private int binarySearch1(int target, MountainArray mountainArr, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (mountainArr.get(mid) < target) {
                left = mid + 1;
            } else if (mountainArr.get(mid) > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int binarySearch2(int target, MountainArray mountainArr, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (mountainArr.get(mid) < target) {
                right = mid - 1;
            } else if (mountainArr.get(mid) > target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}