// Given an integer array nums and an integer k, return the number of good subarrays of nums.
// A good array is an array where the number of different integers in that array is exactly k.

// For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
// A subarray is a contiguous part of an array.

// Example 1:
// Input: nums = [1,2,1,2,3], k = 2
// Output: 7
// Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

// Example 2:
// Input: nums = [1,2,1,3,4], k = 3
// Output: 3
// Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].

// Constraints:
// 1 <= nums.length <= 2 * 104
// 1 <= nums[i], k <= nums.length

import java.util.HashMap;
import java.util.HashSet;

public class SubArrWithKDiffInt {
    // brute force..
    public int SubArrWithKDiffIntegers(int nums[],int k) {
        int n = nums.length;
        int ans = 0;
        for(int i=0;i<n;i++) {
            // HashMap<Integer,Integer> map = new HashMap<>();
            HashSet<Integer> set = new HashSet<>();
            for(int j=i+1;j<n;j++) {
                set.add(nums[j]);
                if(set.size()==k) {
                    ans++;
                } else if (set.size()>k) {
                    break;
                }
            }
        }
        return ans;
    }
    public int SubArrWithKDiffIntOptimal(int nums[],int k) {
        // we'll start from both left and right =0 then we'll put nums[right] to map with frequency.
        int cnt = 0;
        int left = 0;
        int right = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(right<nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            while(map.size()<=k) {
                map.put(nums[left],map.getOrDefault(nums[left],0)-1);
                left++;
            }
            cnt+=right-left+1;
            right++;
        }
        return cnt;
    }
}
