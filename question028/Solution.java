package question028;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82413774
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();
        if (n2 == 0) {
            return 0;
        }
        for (int i = 0; i < n1 - n2 + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean flag = true;
                for (int j = 1; j < n2; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }
}
