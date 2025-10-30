// Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
// A subarray is a contiguous part of the array.

// Example 1:
// Input: nums = [1,0,1,0,1], goal = 2
// Output: 4
// Explanation: The 4 subarrays are bolded and underlined below:
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]

// Example 2:
// Input: nums = [0,0,0,0,0], goal = 0
// Output: 15

// Constraints:
// 1 <= nums.length <= 3 * 104
// nums[i] is either 0 or 1.
// 0 <= goal <= nums.length
public class BinarySubArrWithSum {
    // here, we've applied the logic of subarr sum<=k with slight modification. here, array is containing zero that's why we can't use subarray sum<=k
    // if at any position of array, given element is lesser than equal to k in that window that means the previous elements were also.
    // and each element can be considered as subarray so we can take all individual count and elements before it count.
    // eg. nums = [1,0,0,1,1,0] and we've right pointer at index = 2, and left at index = 0 at right pointer, sum is lesser than goal means we can add that individual zero as subarr+ previous subarr 
    // like 0, 0 0 , 1 0 0 and same for all elements.
    public int helper(int[] nums, int goal) {
        if(goal<0) return 0; //edge case for finding num. of subarr equal to goal.
        int cnt = 0;
        int left = 0;
        int right = 0;
        int sum =0;
        while(right<nums.length) {
            sum+=nums[right];
            while(sum>goal) {
                sum-=nums[left];
                left++;
            }
            cnt+=right-left+1;
            right++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int nums[],int goal) {
        // if ew have number of subarr with lesser than goal and goal-1 so subtracting them will give us the number of subarr with goal.
        return helper(nums, goal)-helper(nums, goal-1);
    }
}
