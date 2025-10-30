// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.
package ArraysAndStrings;

public class MostWater {
    public int containerWithMostWater(int[] height) {
        int maxWater = Integer.MIN_VALUE;
        int si = 0;
        int ei = height.length;
        while(si<ei) {
            int ht = Math.min(height[si], height[ei]);
            int width = ei-si;
            int currArea = ht*width;
            maxWater = Math.max(maxWater, currArea);
            if(height[si]<height[ei]) {
                si++;
            } else {
                ei--;
            }
        }
        return maxWater;
    }
}
