package question2011_final_value_of_variable_after_performing_operations;

public class Solution {

  public int finalValueAfterOperations(String[] operations) {
    int result = 0;
    for (String operation : operations) {
      switch (operation) {
        case "--X":
        case "X--":
          result--;
          break;
        default:
          result++;
      }
    }
    return result;
  }

}