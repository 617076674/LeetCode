package contest.question2;

import java.util.*;

public class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> map = new TreeMap<>();
        Set<String> set = new TreeSet<>();
        for (List<String> order : orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            set.add(foodItem);
            if (!map.containsKey(tableNumber)) {
                map.put(tableNumber, new HashMap<>());
            }
            if (!map.get(tableNumber).containsKey(foodItem)) {
                map.get(tableNumber).put(foodItem, 0);
            }
            map.get(tableNumber).put(foodItem, map.get(tableNumber).get(foodItem) + 1);
        }
        System.out.println(map);
        List<List<String>> result = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        firstRow.add("Table");
        for (String s : set) {
            firstRow.add(s);
        }
        result.add(firstRow);
        for (int tableNumber : map.keySet()) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(tableNumber));
            for (int i = 1; i < firstRow.size(); i++) {
                row.add(String.valueOf(map.get(tableNumber).getOrDefault(firstRow.get(i), 0)));
            }
            result.add(row);
        }
        return result;
    }
}