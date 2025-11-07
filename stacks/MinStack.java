package stacks;
import java.util.Stack;
public class MinStack {
    class pair {
    int first;
    int sec;
    public pair(int f,int s) {
        this.first = f;
        this.sec = s;
    }
}
    // we can design a min stack using pair of <Integer,Integer> where 2nd one will be storing minimum element within the stack.
    // TC : O(1) SC : O(2*n)
    Stack<pair> s = new Stack<>();
    int min;
    Stack<Integer> sopt = new Stack<>();
    public void push(int val) {
        if(s.isEmpty()) {
            s.push(new pair(val, val));
        } else {
            s.push(new pair(val,Math.min(val,s.peek().sec)));
        }
    }
    public void pop() {
        if (!s.isEmpty()) {
            s.pop();
        }
    }
    public int peek() {
        if(s.isEmpty()) {
            return -1;
        }
        return s.peek().first;
    }
    public int getMin() {
        if(s.isEmpty()) {
            return -1;
        }
        return s.peek().sec;
    }
    // we can further optimize the space complexity
    // Anytime, we get the minimum value than current minimum, we will insert 2*val-currMinimum
    // 2*val-prevMin = newVal 
    // we'll be storing newVal instead of val and while retriving, we'll get the val from above formula and will return it.
    public void pushOptimal(int val) {
        if(s.isEmpty()) {
            min = val;
            sopt.push(val);
        } else {
            if(val>=min) sopt.push(val);
            else {
                int newVal = 2*val-min;
                sopt.push(newVal);
                min = val;
            }
        }
    }
    public void popOpt() {
        if(sopt.isEmpty()) {
            return;
        } 
        int top = sopt.pop();
        if(top<min) {
            min = 2*min-top;
        }
    }
    public int peekOpt() {
        if(sopt.isEmpty()) {
            return -1;
        }
        int top = sopt.peek();
        if(top>=min) {
            return top;
        }
        return min;
    }
    public int getMinOpt() {
        return min;
    }
}
