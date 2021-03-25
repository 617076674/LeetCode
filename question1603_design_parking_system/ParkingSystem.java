package question1603_design_parking_system;

public class ParkingSystem {

    private int[] size = new int[3], capacity = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        capacity[0] = big;
        capacity[1] = medium;
        capacity[2] = small;
    }
    
    public boolean addCar(int carType) {
        carType--;
        if (size[carType] == capacity[carType]) {
            return false;
        }
        size[carType]++;
        return true;
    }

}