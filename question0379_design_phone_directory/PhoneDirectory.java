package question0379_design_phone_directory;

/**
 * 双数组。
 *
 * 执行用时：11ms，击败98.04%。消耗内存：39.1MB，击败89.61%。
 */
public class PhoneDirectory {
    private boolean[] used; //记录号码是否被使用

    private int[] numbers;  //记录可用号码集合

    private int index;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        used = new boolean[maxNumbers];
        numbers = new int[maxNumbers];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (index == used.length) {
            return -1;
        }
        int number = numbers[index++];
        used[number] = true;
        return number;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return isValid(number) && !used[number];
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (!isValid(number) || check(number)) {
            return;
        }
        used[number] = false;
        numbers[--index] = number;
    }

    private boolean isValid(int number) {
        return number >= 0 && number < used.length;
    }
}