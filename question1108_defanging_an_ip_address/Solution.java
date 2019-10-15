package question1108_defanging_an_ip_address;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为address的长度。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：34.1MB，击败100.00%。
 */
public class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
