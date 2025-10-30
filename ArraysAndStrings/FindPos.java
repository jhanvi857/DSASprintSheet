// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.
// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]
 
// Constraints:
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109
package ArraysAndStrings;
public class FindPos {
    // Sorted arr = binary search..
    public int[] findFirstAndLastPos(int nums[],int tar) {
        int ans[] = new int[2];
        int si = 0;
        int ei = nums.length-1;
        while (si<=ei) {
            int mid = si+(ei-si)/2;
            if(nums[mid]==tar) {
                ans[0] = mid;
                ei = mid-1;         //Here, we're searching in left part so leftmost index occurrence is being placed at ans[0].. 
            } else if(nums[mid]>tar) {
                ei = mid-1;
            } else {
                si = mid+1;
            }
        }
        si = 0;
        ei = nums.length-1;
        while (si<=ei) {
            int mid = si+(ei-si)/2;
            if(nums[mid]==tar) {
                ans[1] = mid;
                si = mid+1; //Seaerching in second part so rightmost occurrence is got in ans[1].. 
            } else if(nums[mid]>tar) {
                ei = mid-1;
            } else {
                si = mid+1;
            }
        }
        return ans;
    }
}
