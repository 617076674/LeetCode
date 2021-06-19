package lcs01_Ju9Xwi;

public class Solution {

    public int leastMinutes(int n) {
        int cur = 0, speed = 1, step = 0;
        while (cur < n) {
            if (cur + speed < n) {
                speed *= 2;
            } else {
                cur += speed;
            }
            step++;
        }
        return step;
    }

}