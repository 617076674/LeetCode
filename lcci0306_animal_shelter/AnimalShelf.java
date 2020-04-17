package lcci0306_animal_shelter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 执行用时：96ms，击败91.44%。消耗内存：49.6MB，击败100.00%。
 */
public class AnimalShelf {
    private Queue<Integer> dog, cat;

    public AnimalShelf() {
        dog = new LinkedList<>();
        cat = new LinkedList<>();
    }
    
    public void enqueue(int[] animal) {
        if (animal[1] == 1) {
            dog.add(animal[0]);
        } else {
            cat.add(animal[0]);
        }
    }
    
    public int[] dequeueAny() {
        if (dog.isEmpty() && cat.isEmpty()) {
            return new int[] {-1, -1};
        }
        if (dog.isEmpty()) {
            return new int[] {cat.poll(), 0};
        } else if (cat.isEmpty()) {
            return new int[] {dog.poll(), 1};
        } else if (dog.peek() < cat.peek()) {
            return new int[] {dog.poll(), 1};
        }
        return new int[] {cat.poll(), 0};
    }
    
    public int[] dequeueDog() {
        if (dog.isEmpty()) {
            return new int[] {-1, -1};
        }
        return new int[] {dog.poll(), 1};
    }
    
    public int[] dequeueCat() {
        if (cat.isEmpty()) {
            return new int[] {-1, -1};
        }
        return new int[] {cat.poll(), 0};
    }
}