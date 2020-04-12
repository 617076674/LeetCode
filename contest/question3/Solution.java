package contest.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * 双引号：字符实体为 &quot; ，对应的字符是 " 。
 * 单引号：字符实体为 &apos; ，对应的字符是 ' 。
 * 与符号：字符实体为 &amp; ，对应对的字符是 & 。
 * 大于号：字符实体为 &gt; ，对应的字符是 > 。
 * 小于号：字符实体为 &lt; ，对应的字符是 < 。
 * 斜线号：字符实体为 &frasl; ，对应的字符是 /
 */
public class Solution {
    public String entityParser(String text) {
        return text.replaceAll("&quot;", "\"").replaceAll("&apos;", "'")
                .replaceAll("&amp;", "&").replaceAll("&gt;", ">")
                .replaceAll("&lt;", "<").replaceAll("&frasl;", "/");
    }
}