package leetcode.collections;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.04.2023
 **/
public class ValidateStackSequence_946 {

    public static void main(String[] args) {

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length) return false;
        int j=0;
        final Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<pushed.length;i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }
}
