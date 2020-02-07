package question0388_longest_absolute_file_path;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串input的长度。
 *
 * 执行用时：1ms，击败86.29%。消耗内存：34.1MB，击败80.95%。
 */
public class Solution {
    public int lengthLongestPath(String input) {
        int n;
        if (null == input || (n = input.length()) == 0) {
            return 0;
        }
        String[] files = input.split("\n");
        int result = 0;
        int[] lengths = new int[n + 1];    //从1开始，第0层就是0
        for (String file : files) {
            int level = file.lastIndexOf('\t') + 2, len = file.length() - level + 1;
            if (file.contains(".")) {
                result = Math.max(result, lengths[level - 1] + len);  //是文件，更新结果
            } else {
                //对于下述目录：
                // dir
                //    subdir1
                //        file1.ext
                //        subsubdir1
                //    subdir2
                //        subsubdir2
                //            file2.ext
                //当遍历到subsubdir1时，sum[2]此时是dir/subdir1的长度，因此更新sum[3]时为dir/subdir1的长度加上subsubdir1的长度
                //当遍历到subdir2时，sum[1]此时是dir的长度，因此更新sum[2]的值为dir的长度加上subdir2的长度
                //当遍历到subsubdir2时，sum[2]此时是dir/subdir2的长度，因此更新sum[3]时为dir/subdir2的长度加上subsubdir2的长度
                lengths[level] = lengths[level - 1] + len + 1;  //是目录，要+1，因为目录有个/的
            }
        }
        return result;
    }
}