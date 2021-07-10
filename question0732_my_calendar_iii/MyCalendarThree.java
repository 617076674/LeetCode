package question0732_my_calendar_iii;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarThree {

    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public MyCalendarThree() {

    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int result = 0, sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
            result = Math.max(result, sum);
        }
        return result;
    }

}