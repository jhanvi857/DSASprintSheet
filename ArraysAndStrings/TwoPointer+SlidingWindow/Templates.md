# We can see 4 kind of patterns in the sliding window and two pointer approach.
## 1. constant window
when some value is given and we've to find the maximum sum by picking up k elements.
```
l = 0, r = n-1;
while(r<n) {
    sum-=arr[l];
    l++;
    r++;
    sum +=arr[r];
    maxSum = max(maxSum,sum);
}
```
## 2. Longest subarray or substring length where [condition].<br>
This is the most asked template in various problems.
<br>
For eg., we want to find longest subarray length with sum<=k.<br>
Brute force : generate all subarrays.
```
for(int i=0 to n) {
    sum = 0;
    for(j=i+1 to n) {
        sum+=arr[j];
        if(sum<=k) {
            maxLen = max(maxLen,j-i+1);
        } else if (sum>k) break; => optimization in brute force..
    }
}
```
Optimal approach : Two pointer + sliding window <br>
algorithm : <br>
1. start with the window size 1.
2. initialize sum = 0. now there are two cases : 1. expand -> r 2. shrink. -> l
3. if current element is satisfying the condition, sum<=k, do r++ and update maxLen.
4. At any moment, you find that the given condition is not satisfying, in this case: if sum becomes >k then we'll shrink the window and shrink until it comes in the valid condition.
```
l = 0;r = 0; sum = 0;maxLen = 0;
while(r< n ) {
    sum+=arr[r];
    if (sum>k) {
        sum-=arr[l];
        l++;
    }
    if(sum<=k) {
        maxLen = max(maxLen,r-l+1);
    }
    r++;
}
```
Time complexity : O(N+N)
Space complexity : O(1)
### If we're asked to return a subarray instead of length, then we've to run a while loop instead of if (sum>k) part.

## 3. No. of subarrays where [condition]
No. of subarrays with sum<=k -> x, <br>
No.of subarrays with sum<=k-1 -> y.<br>
Ans will be x-y.<br>

## 4. Shortest/Minimum window [condition] (Rare)
Once we found out one valid window, then we'll shrink it to find the minimum. Simmilar logic to 2nd pattern. 