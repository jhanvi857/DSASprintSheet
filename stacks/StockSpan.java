package stacks;

import java.util.Stack;

public class StockSpan {
    class Pair {
        int price;
        int span;
        public Pair(int a,int b) {
            this.price = a;
            this.span = b;
        }
    }
    Stack<Pair> s;
    int idx = -1;
    public StockSpan() {
        s = new Stack<>();
    }
    
    public int next(int price) {
        int ans = 1;
        // s.push(new Pair(-1,-1));
        while(!s.isEmpty() && s.peek().price<=price) {
            ans+=s.pop().span;
        }
        s.push(new Pair(price,ans));
        return ans;
    }
}
