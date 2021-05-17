package question1472_design_browser_history;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {

    private List<String> history = new ArrayList<>();

    private int cur;

    private int max;

    public BrowserHistory(String homepage) {
        history.add(homepage);
    }
    
    public void visit(String url) {
        if (history.size() == cur + 1) {
            history.add(url);
        } else {
            history.add(cur + 1, url);
        }
        cur++;
        max = cur;
    }
    
    public String back(int steps) {
        cur = Math.max(0, cur - steps);
        return history.get(cur);
    }
    
    public String forward(int steps) {
        cur = Math.min(max, steps + cur);
        return history.get(cur);
    }

}