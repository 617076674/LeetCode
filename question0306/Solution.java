package question0306;

/**
 * 回溯法。穷举所有的first和second数组合，判断是否满足。
 *
 * 时间复杂度是O(n ^ 3)，其中n为字符串num的长度。空间复杂度是O(n)。
 *
 * 执行用时：5ms，击败32.93%。消耗内存：35.2MB，击败50.72%。
 */
public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n;
        if (null == num || (n = num.length()) < 3) {
            return false;
        }
        for (int i = 1; i < n; i++) {
            String first = num.substring(0, i);
            for (int j = i + 1; j < n; j++) {
                String second = num.substring(i, j);
                if (isAdditiveNumber(num, first, second, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 对字符串num，取第一个数字为first，第二个数字为second，count为0表示num中只有2个数，count > 0则表示num中至少有3个数
     */
    private boolean isAdditiveNumber(String num, String first, String second, int count) {
        if (!isValid(first) || !isValid(second)) {      //如果数字first或second中有一个非法，直接返回false
            return false;
        }
        if (num.length() == first.length() + second.length()) { //如果num中只有first和second中两个数
            if (count == 0) {   //如果count为0，说明不满足题目描述的至少3个数的要求
                return false;
            }
            return true;    //走到这里，说明count > 0，满足题目描述的至少3个数的要求
        }
        String sum = add(first, second);    //对first和second求和
        if (num.substring(first.length() + second.length()).startsWith(sum)) {
            return isAdditiveNumber(num.substring(first.length()), second, sum, count + 1); //递归
        }
        return false;
    }

    /**
     * 判断字符串s是否满足题目所描述的数字要求：即如果不是数字0，则不能以0开头
     */
    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        return true;
    }

    /**
     * 字符串加法
     */
    private String add(String s1, String s2) {
        int flag = 0, index1 = s1.length() - 1, index2 = s2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (index1 < 0 && index2 < 0) {
                if (flag > 0) {
                    sb.insert(0, flag);
                }
                break;
            } else if (index1 < 0 && index2 >= 0) {
                int num = s2.charAt(index2) - '0' + flag;
                if (num >= 10) {
                    num -= 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                sb.insert(0, num);
                index2--;
            } else if (index1 >= 0 && index2 < 0) {
                int num = s1.charAt(index1) - '0' + flag;
                if (num >= 10) {
                    num -= 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                sb.insert(0, num);
                index1--;
            } else {
                int num = s1.charAt(index1) - '0' + s2.charAt(index2) - '0' + flag;
                if (num >= 10) {
                    num -= 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                sb.insert(0, num);
                index1--;
                index2--;
            }
        }
        return sb.toString();
    }
}
