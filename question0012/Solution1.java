package question0012;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82012326
 */
public class Solution1 {

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        if (num >= 1000) {
            int nt = num / 1000;
            for (int i = 0; i < nt; i++) {
                stringBuilder.append("M");
            }
            num = num - nt * 1000;
        }
        if (num >= 100) {
            int nh = num / 100;
            if (nh == 9) {
                stringBuilder.append("CM");
            } else if (nh < 9 && nh >= 5) {
                stringBuilder.append("D");
                for (int i = 0; i < nh - 5; i++) {
                    stringBuilder.append("C");
                }
            } else if (nh == 4) {
                stringBuilder.append("CD");
            } else {
                for (int i = 0; i < nh; i++) {
                    stringBuilder.append("C");
                }
            }
            num = num - nh * 100;
        }
        if (num >= 10) {
            int nh = num / 10;
            if (nh == 9) {
                stringBuilder.append("XC");
            } else if (nh < 9 && nh >= 5) {
                stringBuilder.append("L");
                for (int i = 0; i < nh - 5; i++) {
                    stringBuilder.append("X");
                }
            } else if (nh == 4) {
                stringBuilder.append("XL");
            } else {
                for (int i = 0; i < nh; i++) {
                    stringBuilder.append("X");
                }
            }
            num = num - nh * 10;
        }
        if (num == 9) {
            stringBuilder.append("IX");
        } else if (num < 9 && num >= 5) {
            stringBuilder.append("V");
            for (int i = 0; i < num - 5; i++) {
                stringBuilder.append("I");
            }
        } else if (num == 4) {
            stringBuilder.append("IV");
        } else {
            for (int i = 0; i < num; i++) {
                stringBuilder.append("I");
            }
        }
        return stringBuilder.toString();
    }
}
