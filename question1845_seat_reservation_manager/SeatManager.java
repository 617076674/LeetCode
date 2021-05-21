package question1845_seat_reservation_manager;

import java.util.PriorityQueue;

public class SeatManager {

    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public SeatManager(int n) {
        for (int i = 1; i <= n; i++) {
            priorityQueue.add(i);
        }
    }
    
    public int reserve() {
        return priorityQueue.poll();
    }
    
    public void unreserve(int seatNumber) {
        priorityQueue.add(seatNumber);
    }

}