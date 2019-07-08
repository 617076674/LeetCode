package question0406;

/**
 * @author qianyihui
 * @date 2019-07-07
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        swap(people, 1, 2);
        return people;
    }

    private void swap(int[][] people, int i, int j) {
        int[] tmp = people[i];
        people[i] = people[j];
        people[j] = tmp;
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        people = new Solution().reconstructQueue(people);
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people[0].length; j++) {
                System.out.print(people[i][j] + " ");
            }
            System.out.println();
        }
    }
}
