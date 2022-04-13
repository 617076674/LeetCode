package question0635;

import java.util.ArrayList;
import java.util.List;

public class LogSystem {

  private static class Log {
    int id;
    long timestamp;

    public Log(int id, long timestamp) {
      this.id = id;
      this.timestamp = timestamp;
    }

  }

  private List<Log> logList = new ArrayList<>();

  public LogSystem() {

  }

  public void put(int id, String timestamp) {
    logList.add(new Log(id, str2Long(timestamp)));
  }

  public List<Integer> retrieve(String start, String end, String granularity) {
    List<Integer> idList = new ArrayList<>();
    long left = -1, right = -1;
    if ("Year".equals(granularity)) {
      left = str2Long(start.substring(0, 4) + ":00:00:00:00:00");
      right = str2Long(end.substring(0, 4) + ":12:31:23:59:59");
    } else if ("Month".equals(granularity)) {
      left = str2Long(start.substring(0, 7) + ":00:00:00:00");
      right = str2Long(end.substring(0, 7) + ":31:23:59:59");
    } else if ("Day".equals(granularity)) {
      left = str2Long(start.substring(0, 10) + ":00:00:00");
      right = str2Long(end.substring(0, 10) + ":23:59:59");
    } else if ("Hour".equals(granularity)) {
      left = str2Long(start.substring(0, 13) + ":00:00");
      right = str2Long(end.substring(0, 13) + ":59:59");
    } else if ("Minute".equals(granularity)) {
      left = str2Long(start.substring(0, 16) + ":00");
      right = str2Long(end.substring(0, 16) + ":59");
    } else {
      left = str2Long(start);
      right = str2Long(end);
    }
    for (Log log : logList) {
      if (log.timestamp >= left && log.timestamp <= right) {
        idList.add(log.id);
      }
    }
    return idList;
  }

  private static long str2Long(String timestamp) {
    int year = Integer.parseInt(timestamp.substring(0, 4));
    int month = Integer.parseInt(timestamp.substring(5, 7));
    int day = Integer.parseInt(timestamp.substring(8, 10));
    int hour = Integer.parseInt(timestamp.substring(11, 13));
    int minute = Integer.parseInt(timestamp.substring(14, 16));
    int second = Integer.parseInt(timestamp.substring(17));
    return (((((year * 1L * 2 * 366) * 12 + month) * 31 + day) * 24 + hour) * 60 + minute) * 60 + second;
  }

}
