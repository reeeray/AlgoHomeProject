package leetcode.structures;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.01.2024
 **/
public class MyQueue_232 {

    private final Stack<Integer> first;
    private final Stack<Integer> second;

    public MyQueue_232() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(final int x) {
        while(!first.isEmpty()) {
            second.push(first.pop());
        }
        first.add(x);
        while (!second.isEmpty()){
            first.push(second.pop());
        }
    }

    public int pop() {
        return first.pop();
    }

    public int peek() {
        return first.peek();
    }

    public boolean empty() {
        return first.isEmpty();
    }
}
