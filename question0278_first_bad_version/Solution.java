package question0278_first_bad_version;

public class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            if (left + 1 == right) {
                if (isBadVersion(left)) {
                    return left;
                }
                return right;
            }
            int mid = left + ((right - left) >> 1);
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}