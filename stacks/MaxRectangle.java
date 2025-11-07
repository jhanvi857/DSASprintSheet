// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

// Example 1:
// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 6
// Explanation: The maximal rectangle is shown in the above picture.

// Example 2:
// Input: matrix = [["0"]]
// Output: 0

// Example 3:
// Input: matrix = [["1"]]
// Output: 1

// Constraints:
// rows == matrix.length
// cols == matrix[i].length
// 1 <= rows, cols <= 200
// matrix[i][j] is '0' or '1'.
package stacks;

import java.util.Stack;

public class MaxRectangle {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int right[] = new int[n];
        int left[] = new int[n];
        for(int i = n-1;i>=0;i--){
            while(s.size()>0 && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            right[i] = s.isEmpty()?n:s.peek();
            s.push(i);
        }
        while(!s.isEmpty()){
            s.pop();
        }
        for(int i =0;i<n;i++){
            while(s.size()>0 && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            left[i] = s.isEmpty()?-1:s.peek();
            s.push(i);
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            int wt = right[i]-left[i]-1;
            int currArea = heights[i]*wt;
            ans = Math.max(currArea,ans);
        }
        return ans;
    }
    public int maximalRectangle(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int preSum[][] = new int[m][n];
        int maxArea = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (mat[i][j] == '1') {
                    preSum[i][j] = (i == 0) ? 1 : preSum[i - 1][j] + 1;
                } else {
                    preSum[i][j] = 0;
                }
            }
        }
        for(int i=0;i<m;i++) {
            maxArea = Math.max(maxArea,largestRectangleArea(preSum[i]));
        }
        return maxArea;
    }
}
