package question1418_display_table_of_food_orders_in_a_restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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
        List<List<String>> result = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        firstRow.add("Table");
        firstRow.addAll(set);
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