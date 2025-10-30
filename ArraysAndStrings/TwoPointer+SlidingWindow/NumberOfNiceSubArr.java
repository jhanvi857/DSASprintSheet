// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
// Return the number of nice sub-arrays.

// Example 1:
// Input: nums = [1,1,2,1,1], k = 3
// Output: 2
// Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

// Example 2:
// Input: nums = [2,4,6], k = 1
// Output: 0
// Explanation: There are no odd numbers in the array.

// Example 3:
// Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
// Output: 16

// Constraints:
// 1 <= nums.length <= 50000
// 1 <= nums[i] <= 10^5
// 1 <= k <= nums.length
public class NumberOfNiceSubArr {
    public int helper(int[] nums, int goal) {
        if(goal<0) return 0; //edge case for finding num. of subarr equal to goal.
        int cnt = 0;
        int left = 0;
        int right = 0;
        int sum =0;
        while(right<nums.length) {
            sum+=nums[right]%2; //small change here. add %2 so if it's odd then 1 will be added and if even, 0 will be added.
            while(sum>goal) {
                sum-=nums[left]%2; //same small change applies here.
                left++;
            }
            cnt+=right-left+1;
            right++;
        }
        return cnt;
    }
    public int NumberOfNiceSubArray(int nums[],int goal) {
        // this problem is similar to BinarySubArrWithSum we can place 1 in place of odd numbers and 0 in place of even numbers and we want to find the sum=k
    // only required change is we will do nums[right]%2 when we add to sum and same when subtracting nums[left] from the sum.
        return helper(nums, goal)-helper(nums, goal-1);
    }
}
