package question0374_guess_number_higher_or_lower;

public class GuessGame {
    private int pick;
    public int guess(int num) {
        if (num > pick) {
            return 1;
        } else if (num < pick) {
            return -1;
        }
        return 0;
    }
}
