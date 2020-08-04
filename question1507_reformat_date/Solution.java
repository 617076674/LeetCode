package question1507_reformat_date;

import java.util.HashMap;
import java.util.Map;

/**
 * 执行用时：29ms，击败6.39%。消耗内存：40.1MB，击败6.12%。
 */
public class Solution {
  public String reformatDate(String date) {
    Map<String, String> monthMap = new HashMap<>();
    String[] months =
        {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    for (int i = 0; i < months.length; i++) {
      monthMap.put(months[i], String.format("%02d", i + 1));
    }
    String[] dateToArray = date.split(" ");
    return dateToArray[2] + "-" + monthMap.get(dateToArray[1]) + "-" + String.format("%02d",
        Integer.parseInt(dateToArray[0].substring(0, dateToArray[0].length() - 2)));
  }
}