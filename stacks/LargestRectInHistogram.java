package stacks;

import java.util.Stack;

public class LargestRectInHistogram {
    public int largestHistogram(int height[]) {
        int maxArea = 0;
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<height.length;i++) {
            while(!s.isEmpty() && height[s.peek()]>height[i]) {
                int el = s.peek();
                s.pop();
                int nse = i;
                int pse = s.isEmpty()?-1:s.peek();
                maxArea = Math.max(maxArea,height[el]*(nse-pse-1));
            }
        }
        while(!s.isEmpty()) {
            int nse = height.length;
            int el = s.peek();
            s.pop();
            int pse = s.isEmpty()?-1:s.peek();
            maxArea = Math.max(maxArea,height[el]*(nse-pse-1));
        }
        return maxArea;
    }
}
