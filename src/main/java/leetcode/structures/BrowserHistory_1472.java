package leetcode.structures;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.03.2023
 **/
public class BrowserHistory_1472 {

    private Stack<String> back;
    private Stack<String> forward;
    private String current;

    public BrowserHistory_1472(final String homepage) {
        this.current = homepage;
        this.back = new Stack<>();
        this.forward = new Stack<>();
    }

    public void visit(final String url) {
        forward.clear();
        back.add(current);
        current = url;
    }

    public String back(final int steps) {
        if(back.isEmpty()) {
            return current;
        }
        for(int i=0; i<steps; i++) {
            forward.push(current);
            current = back.pop();
            if(back.isEmpty()) {
                return current;
            }
        }
        return current;
    }

    public String forward(final int steps) {
        if(forward.isEmpty()) {
            return current;
        }
        for(int i=0; i<steps; i++) {
            back.push(current);
            current = forward.pop();
            if(forward.isEmpty()) {
                return current;
            }
        }
        return current;
    }


//    public BrowserHistory(String homepage) {
//        visit(homepage);
//    }
//
//    public void visit(String url) {
//        if (++index < urls.size())
//            urls.set(index, url);
//        else
//            urls.add(url);
//        lastIndex = index;
//    }
//
//    public String back(int steps) {
//        index = Math.max(0, index - steps);
//        return urls.get(index);
//    }
//
//    public String forward(int steps) {
//        index = Math.min(lastIndex, index + steps);
//        return urls.get(index);
//    }
//    private List<String> urls = new ArrayList<>();
}
