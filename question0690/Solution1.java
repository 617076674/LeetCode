package question0690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 深搜。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为员工数量。
 *
 * 执行用时：15ms，击败69.30%。消耗内存：74.7MB，击败5.21%。
 */
public class Solution1 {
    private int result = 0;

    private Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        dfs(id);
        return result;
    }

    private void dfs(int id) {
        Employee now = map.get(id);
        result += now.importance;
        for (Integer tmp : now.subordinates) {
            dfs(tmp);
        }
    }
}
