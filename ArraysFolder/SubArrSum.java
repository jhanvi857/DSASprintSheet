// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2

// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2

package ArraysFolder;

import java.util.HashMap;

public class SubArrSum {
    public int cntSubArrWithSumK(int nums[],int k) {
        int n = nums.length;
        int prefix = 0;
        int cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            prefix+=nums[i];
            int diff = prefix-k;
            if(map.containsKey(diff)) {
                cnt+=map.get(diff);
            }
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }
        return cnt;
    }
}
