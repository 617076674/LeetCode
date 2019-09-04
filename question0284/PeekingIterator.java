package question0284;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 将原迭代器遍历得到的值保存进一个list里，并初始化一个指针index表示当前位置。
 *
 * 构造函数的时间复杂度是O(n)，其中n为传入的迭代器中的元素数量。
 *
 * peek()、next()和hasNext()函数的时间复杂度均是O(1)。
 *
 * 执行用时：105ms，击败22.36%。消耗内存：36.4MB，击败64.47%。
 */
public class PeekingIterator implements Iterator<Integer> {

	private List<Integer> list = new ArrayList<>();

	private int index = 0;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    while (iterator.hasNext()) {
	    	list.add(iterator.next());
		}
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return list.get(index);
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return list.get(index++);
	}

	@Override
	public boolean hasNext() {
	    return index < list.size();
	}
}