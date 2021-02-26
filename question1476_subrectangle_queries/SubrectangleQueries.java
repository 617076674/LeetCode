package question1476_subrectangle_queries;

import java.util.ArrayList;
import java.util.List;

public class SubrectangleQueries {

    private int[][] data;

    private List<Operation> operationList = new ArrayList<>();

    private static class Operation {

        int row1;

        int col1;

        int row2;

        int col2;

        int newValue;

        public Operation(int row1, int col1, int row2, int col2, int newValue) {
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
            this.newValue = newValue;
        }

    }

    public SubrectangleQueries(int[][] rectangle) {
        data = rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        operationList.add(new Operation(row1, col1, row2, col2, newValue));
    }
    
    public int getValue(int row, int col) {
        for (int i = operationList.size() - 1; i >= 0; i--) {
            Operation operation = operationList.get(i);
            if (row >= operation.row1 && row <= operation.row2 && col >= operation.col1
                && col <= operation.col2) {
                return operation.newValue;
            }
        }
        return data[row][col];
    }

}