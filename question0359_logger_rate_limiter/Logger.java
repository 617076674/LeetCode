package question0359_logger_rate_limiter;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。
 *
 * 执行用时：41ms，击败42.11%。消耗内存：52.6MB，击败100.00%。
 */
public class Logger {
    private Map<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || map.get(message) + 10 <= timestamp) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}