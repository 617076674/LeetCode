package contest_3_20.question3;

public class Solution {

    private Integer[][] memo;
  public int minSideJumps(int[] obstacles) {
      memo = new Integer[obstacles.length + 3][4];
    return minSideJumps(obstacles, 1, 2);
  }

  public static void main(String[] args) {
    int[] obstacles = {0,2,1,0,3,0};
    System.out.println(new Solution().minSideJumps(obstacles));
  }

  private int minSideJumps(int[] obstacles, int index, int road) {
    if (index == obstacles.length - 1) {
      return 0;
    }
    if (null != memo[index][road]) {
        return memo[index][road];
    }
    int result = Integer.MAX_VALUE;
    if (obstacles[index + 1] == 0) {
      result = Math.min(result, minSideJumps(obstacles, index + 1, road));
    } else if (obstacles[index + 1] == 1) {
      if (road == 1) {
        if (obstacles[index] != 2) {
          result = Math.min(result, 1 + minSideJumps(obstacles, index + 1, 2));
        }
        if (obstacles[index] != 3) {
          result = Math.min(result, 1 + minSideJumps(obstacles, index + 1, 3));
        }
      } else if (road == 2) {
        if (obstacles[index] != 2) {
          result = Math.min(result, minSideJumps(obstacles, index + 1, 2));
        }
        if (obstacles[index] != 3) {
          result = Math.min(result, 1 + minSideJumps(obstacles, index + 1, 3));
        }
      } else {
        if (obstacles[index] != 2) {
          result = Math.min(result, 1 + minSideJumps(obstacles, index + 1, 2));
        }
        if (obstacles[index] != 3) {
          result = Math.min(result, minSideJumps(obstacles, index + 1, 3));
        }
      }
    } else if (obstacles[index + 1] == 2) {
      if (road == 1) {
        if (obstacles[index] != 1) {
          result = Math.min(result, minSideJumps(obstacles, index + 1, 1));
        }
        if (obstacles[index] != 3) {
          result = Math.min(result, 1 + minSideJumps(obstacles, index + 1, 3));
        }
      } else if (road == 2) {
        if (obstacles[index] != 1) {
          result = Math.min(result, 1 + minSideJumps(obstacles, index + 1, 1));
        }
        if (obstacles[index] != 3) {
          result = Math.min(result, 1 + minSideJumps(obstacles, index + 1, 3));
        }
      } else {
        if (obstacles[index] != 1) {
          result = Math.min(result, 1 + minSideJumps(obstacles, index + 1, 1));
        }
        if (obstacles[index] != 3) {
          result = Math.min(result, minSideJumps(obstacles, index + 1, 3));
        }
      }
    } else {
      if (road == 1) {
        if (obstacles[index] != 1) {
          result = Math.min(result, minSideJumps(obstacles, index + 1, 1));
        }
        if (obstacles[index] != 2) {
          result = Math.min(result, 1 + minSideJumps(obstacles, index + 1, 2));
        }
      } else if (road == 2) {
        if (obstacles[index] != 1) {
          result = Math.min(result, 1 + minSideJumps(obstacles, index + 1, 1));
        }
        if (obstacles[index] != 2) {
          result = Math.min(result, minSideJumps(obstacles, index + 1, 2));
        }
      } else {
        if (obstacles[index] != 1) {
          result = Math.min(result, 1 + minSideJumps(obstacles, index + 1, 1));
        }
        if (obstacles[index] != 2) {
          result = Math.min(result, 1 + minSideJumps(obstacles, index + 1, 2));
        }
      }
    }
    memo[index][road] = result;
    return result;
  }
}