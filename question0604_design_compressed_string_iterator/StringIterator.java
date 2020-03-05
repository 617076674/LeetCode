package question0604_design_compressed_string_iterator;

/**
 * 记录每个字符出现的次数，一旦该出现的次数用完，取下一个新字符。
 *
 * 执行用时：17ms，击败47.06%。消耗内存：41.5MB，击败5.55%。
 */
public class StringIterator {
    private String s;

    private int index, num;

    private char c;

    public StringIterator(String s) {
        this.s = s;
    }

    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        if (num == 0) {
            c = s.charAt(index++);
            while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                num = num * 10 + s.charAt(index++) - '0';
            }
        }
        num--;
        return c;
    }

    public boolean hasNext() {
        return index != s.length() || num != 0;
    }
}