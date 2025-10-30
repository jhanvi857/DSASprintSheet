// Given a string s consisting only of characters a, b and c.
// Return the number of substrings containing at least one occurrence of all these characters a, b and c.

// Example 1:
// Input: s = "abcabc"
// Output: 10
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

// Example 2:
// Input: s = "aaacb"
// Output: 3
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 

// Example 3:
// Input: s = "abc"
// Output: 1
 
// Constraints:
// 3 <= s.length <= 5 x 10^4
// s only consists of a, b or c characters.
public class NumOfSubStrWIthAll3Char {
    // Brute force sol : generate all substrings and find answer.
    // one optimization we can do is if we get one valid substring then we can add all substrings after that index.
    // for eg., if the s = bbacba then we will get first valid substring at i=0 and j = 3 so we can definitely add cba also to our ans coz if one substringis valid then if we add other letters it's still gonna be valid substring.
    // Hence, we will add n-j to count and break out from innner loop.
    // still TC will be n^2 for worst cases like s = aaaa we've to traverse whole string n^2 times.
    public int NumOfSubStrContainingAll3Characters(String s) {
        int ans = 0;
        int n = s.length();
        for(int i=0;i<n;i++) {
            int hash[] = new int[3];
            for(int j=0;j<n;j++) {
                hash[s.charAt(j)-'a'] = 1;
                if(hash[0]+hash[1]+hash[2]==3) {
                    ans+=n-j;
                    break;
                }
            }
        }
        return ans;
    }   
    // optimal : two pointer + sliding window
    public int NumOfSubStrContainingAll3CharactersOptimal(String s, int k) {
        // with every character, there's a substring that ends 
        // eg : s = bbacba 
        // we'll put a,b,c with freq -1 in hashmap. 
        // we start from idx = 0(b) we'll put index of b as value in hashmap. now in hashmap key,val pair is b,0 for next b, val will be 1 so in hashmap ther will be b,1.
        // now, we'll do same for a and c. now the moment every char appeared once, we'll find the minimum index occurence among them.
        // hashmap contains b,1 a,2 c,3 minimum idx among all char is 1 so we'll add 1+current string count means 1+1=2 in answer. now when we move further, val.of b will be updated as 4.
        // now, hashmap has minimum value of a = 2 so we'll add 2+current substr count = 3 in ans.
        // logic is same as brute force but here, ew're traversing whole string just once and taking the minimum valid substr and substr before it.
        // we'll use hash array of 3 size for better SC. 
        int ans = 0;
        int freq[] = {-1,-1,-1};
        int n = s.length();
        for(int i=0;i<n;i++) {
            freq[s.charAt(i)-'a'] = i;
            if(freq[0]!=-1 && freq[1]!=-1 && freq[2]!=-1) {
                ans+=1+Math.min(freq[0],Math.min(freq[1],freq[2]));
            }
        }
        return ans;
    }
}
