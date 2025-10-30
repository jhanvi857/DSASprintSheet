public class LongestSubStr {
    public int LongestSubStringWithoutRepeatingChar(String str) {
        // TC : O(N)
        // SC : O(256)
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int hash[] = new int[256];
        while(right<str.length()) {
            if(hash[str.charAt(right)]!=-0) {
                if(hash[str.charAt(right)]>=left) {
                    left = hash[str.charAt(right)]+1;
                }
            }
            maxLen = Math.max(maxLen, right-left+1);
            hash[str.charAt(right)] = right;
            right++;
        }
        return maxLen;
    }    
}
