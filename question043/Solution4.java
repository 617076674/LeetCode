package question043;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82710845
 */
public class Solution4 {

    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        if (array1[0] == '0' || array2[0] == '0') {
            return "0";
        }
        String[] strings = new String[n2];
        for (int i = n2 - 1; i >= 0; i--) {
            String string = "";
            int flag = 0;
            for (int j = n1 - 1; j >= 0; j--) {
                int num = (array1[j] - '0') * (array2[i] - '0');
                string += (num + flag) % 10;
                flag = (num + flag) / 10;
            }
            if (flag > 0) {
                string += flag;
            }
            strings[n2 - i - 1] = string;
        }
        String result = "";
        int flag = 0;
        for (int i = 0; i < strings[n2 - 1].length() + n2 - 1; i++) {
            int sum = 0;
            for (int j = 0; j < n2; j++) {
                if (i - j < strings[j].length() && i - j >= 0) {
                    sum += strings[j].charAt(i - j) - '0';
                }
            }
            int num = (sum + flag) % 10;
            flag = (sum + flag) / 10;
            result = num + result;

        }
        if (flag > 0) {
            result = flag + result;
        }
        return result;
    }
}
