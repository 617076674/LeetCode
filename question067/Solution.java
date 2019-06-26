package question067;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82847863
 */
public class Solution {

    public String addBinary(String a, String b) {
        int na = a.length();
        int nb = b.length();
        int flag = 0;
        String result = "";
        int i = na - 1;
        int j = nb - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            int num = a.charAt(i) - '0' + b.charAt(j) - '0' + flag;
            if (num >= 2) {
                num -= 2;
                flag = 1;
            } else {
                flag = 0;
            }
            result = num + result;
        }
        if (i != -1) {
            for (; i >= 0; i--) {
                int num = a.charAt(i) - '0' + flag;
                if (num >= 2) {
                    num -= 2;
                    flag = 1;
                } else {
                    flag = 0;
                }
                result = num + result;
            }
        } else if (j != -1) {
            for (; j >= 0; j--) {
                int num = b.charAt(j) - '0' + flag;
                if (num >= 2) {
                    num -= 2;
                    flag = 1;
                } else {
                    flag = 0;
                }
                result = num + result;
            }
        }
        if (flag == 1) {
            return 1 + result;
        } else {
            return result;
        }
    }
}
