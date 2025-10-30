// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
// Return the length of the longest substring containing the same letter you can get after performing the above operations.

// Example 1:
// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

// Example 2:
// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.
 
// Constraints:
// 1 <= s.length <= 105
// s consists of only uppercase English letters.
// 0 <= k <= s.length
public class LongestRepeatingCharReplacement {
    public int LongestRepeatingCharacterReplacement(String s, int k) {
        // brute force : generate all substrings...
        int n = s.length();
        int maxLen = 0;
        for(int i=0;i<n;i++) {
            int freq[] = new int[26];
            int maxfreq = 0;
            for(int j=i;j<n;j++) {
                freq[s.charAt(j)-'a']++;
                maxfreq = Math.max(maxfreq,freq[s.charAt(j)-'a']);
                int changes = (j-i+1)-maxfreq;
                if(changes<=k) {
                    maxLen = Math.max(maxLen,j-i+1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }
    public int LongestRepeatingCharReplacementOptimal(String s, int k) {
        // we'll use the len-maxFreq<=k means if the required conversions are lesser than given k.
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int freq[] = new int[26];
        int maxFreq = 0;
        while (right<s.length()) {
            freq[s.charAt(right)-'a']++;
            maxFreq = Math.max(freq[s.charAt(right)-'a'], maxFreq);
            while((right-left+1)-maxFreq>k) {
                freq[s.charAt(left)-'a']--;
                maxFreq = 0;
                // for(int i=0;i<25;i++) {
                //     maxFreq = Math.max(maxFreq, freq[i]);
                // }
                // we don't need to check again for maxfreq coz before that we're decreasing the freq. so if maxfreq = 3, and we're doing --,
                // then, according to formula len-maxFreq<=k if length is same and maxfreq is decreasing then we can't get maxlen by decreasing.
                left++;
            }
            if((right-left+1)-maxFreq<=k) {
                maxLen = Math.max(maxLen,right-left+1);
            }
            right++;
        }
        return maxLen;
    }
}
