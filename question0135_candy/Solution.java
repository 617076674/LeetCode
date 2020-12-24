package question0135_candy;

public class Solution {

    public int candy(int[] ratings) {
        int[] candies1 = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) {
                candies1[i] = 1;
            } else if (ratings[i] > ratings[i - 1]) {
                candies1[i] = candies1[i - 1] + 1;
            } else {
                candies1[i] = 1;
            }
        }
        int[] candies2 = new int[ratings.length];
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i == ratings.length - 1) {
                candies2[i] = 1;
            } else if (ratings[i] > ratings[i + 1]) {
                candies2[i] = candies2[i + 1] + 1;
            } else {
                candies2[i] = 1;
            }
        }
        int result = 0;
        for (int i = 0; i < ratings.length; i++) {
            result += Math.max(candies1[i], candies2[i]);
        }
        return result;
    }

}
