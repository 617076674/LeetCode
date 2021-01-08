package lcci1701_add_without_plus;

public class Solution {

    public int add(int a, int b) {
        while (true) {
            int tmp1 = a ^ b, tmp2 = (a & b) << 1;
            if (tmp2 == 0) {
                return tmp1;
            }
            a = tmp1;
            b = tmp2;
        }
    }

}