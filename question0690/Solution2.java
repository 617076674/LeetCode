package question0690;

import java.util.*;

/**
 * 广搜。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为员工数量。
 *
 * 执行用时：13ms，击败94.85%。消耗内存：58.1MB，击败66.09%。
 */
public class Solution2 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int result = 0;
        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        while (!queue.isEmpty()) {
            Employee now = queue.poll();
            result += now.importance;
            for (Integer tmp : now.subordinates) {
                queue.add(map.get(tmp));
            }
        }
        return result;
    }
}
