package question1947_maximum_compatibility_score_sum;

public class Solution {

  private int result;

  private boolean[] visitedMentor;

  private int[][] score;

  public int maxCompatibilitySum(int[][] students, int[][] mentors) {
    score = new int[students.length][mentors.length];
    for (int i = 0; i < students.length; i++) {
      for (int j = 0; j < mentors.length; j++) {
        int[] student = students[i], mentor = mentors[j];
        for (int k = 0; k < student.length; k++) {
          if (student[k] == mentor[k]) {
            score[i][j]++;
          }
        }
      }
    }
    visitedMentor = new boolean[mentors.length];
    dfs(0, 0);
    return result;
  }

  private void dfs(int i, int temp) {
    if (i == score.length) {
      result = Math.max(temp, result);
      return;
    }
    for (int j = 0; j < visitedMentor.length; j++) {
      if (!visitedMentor[j]) {
        visitedMentor[j] = true;
        dfs(i + 1, temp + score[i][j]);
        visitedMentor[j] = false;
      }
    }
  }

}