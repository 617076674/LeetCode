package question2001_number_of_pairs_of_interchangeable_rectangles;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {

    private static class Number {
        long num1, num2;

        public Number(long num1, long num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Number number = (Number) o;
            return num1 == number.num1 &&
                num2 == number.num2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num1, num2);
        }
    }

    //欧几里得最大公约数算法
    private long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public long interchangeableRectangles(int[][] rectangles) {
        Map<Number, Long> map = new HashMap<>();
        for (int[] rectangle : rectangles) {
            long gcdNum = gcd(rectangle[0], rectangle[1]);
            Number number = new Number(rectangle[0] / gcdNum, rectangle[1] / gcdNum);
            map.put(number, map.getOrDefault(number, 0L) + 1);
        }
        long result = 0L;
        for (long count : map.values()) {
            result += count * (count - 1) / 2;
        }
        return result;
    }

}