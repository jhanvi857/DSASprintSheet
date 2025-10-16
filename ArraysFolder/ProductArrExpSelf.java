package ArraysFolder;

public class ProductArrExpSelf {
    public int[] productOfArrExpSelf(int nums[]) {
        // approach with two arr- prefix, suffix..
        int n = nums.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = 1;
        suffix[n-1] = 1;
        for(int i=1;i<n;i++) {
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--) {
            suffix[i] = suffix[i+1]*nums[i+1];
        }
        int ans[] = new int[n];
        for(int i=0;i<n;i++) {
            ans[i] = prefix[i]*suffix[i];
        }
        return ans;
    }
    // Optimal approach : don't use prefix array, directly multiply previous element in ans array with nums[i-1]
    // and don't need separate suffix array we can directly use variable ans multiply it to current ans[i] as prefix is already stored in asn[i]
    // we can also do reverse thing, complexity will be same for both..

    // why use suffix variable ?
    // because we already have some value in ans array which is prefix of current element, if we directly multiply and store,
    // then previous prefix value will be overwirted.
    public int[] productOfArrExpSelfOptimal(int nums[]) {
        int n = nums.length;
        int ans[] = new int[n];
        ans[0] = 1;
        for(int i=1;i<n;i++) {
            ans[i] = ans[i-1]*nums[i-1];
        }
        int suffix = 1;
        for(int i=n-2;i>=0;i--) {
            suffix*=nums[i+1];
            ans[i]*=suffix;
        }
        return ans;
    }
}
