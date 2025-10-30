import java.util.HashMap;

public class LongestSubStrWithKDistChar {
    public static int LongestSubStrWithKDistCharacters(String s,int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(right<s.length()) {
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            if (map.size()>k) {
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
                if(map.get(s.charAt(left))==0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            if(map.size()<=k) {
                maxLen = Math.max(maxLen,right-left+1);
            }
            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "aaabbccd";
        System.out.println(LongestSubStrWithKDistCharacters(s, 2));
    }
}
