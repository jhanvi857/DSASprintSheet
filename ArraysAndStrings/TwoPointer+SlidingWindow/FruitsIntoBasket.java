// You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
// You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
// You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
// Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
// Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
// Given the integer array fruits, return the maximum number of fruits you can pick.

// Example 1:
// Input: fruits = [1,2,1]
// Output: 3
// Explanation: We can pick from all 3 trees.

// Example 2:
// Input: fruits = [0,1,2,2]
// Output: 3
// Explanation: We can pick from trees [1,2,2].
// If we had started at the first tree, we would only pick from trees [0,1].

// Example 3:
// Input: fruits = [1,2,3,2,2]
// Output: 4
// Explanation: We can pick from trees [2,3,2,2].
// If we had started at the first tree, we would only pick from trees [1,2].

// Constraints:
// 1 <= fruits.length <= 105
// 0 <= fruits[i] < fruits.length

import java.util.HashMap;
import java.util.HashSet;

public class FruitsIntoBasket {
    // We can say this problem as max subarr with at most 2 unique elements..
    // Brute force = generate all subarr and find max num of fruits you can obtain in a basket.
    public int totalFruit(int nums[]) {
        int maxLen = 0;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j=i;j<n;j++) {
                set.add(nums[i]);
                if(set.size()<=2) {
                    maxLen = Math.max(maxLen,j-i+1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }
    public int totalFruitOptimal(int nums[]) {
        int maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right<nums.length) {
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            if(map.size()>2) {
                if (map.size()>2) {
                    map.put(nums[left],map.get(nums[left]-1));
                    if(map.get(nums[left])==0) {
                        map.remove(nums[left]);
                    }
                    left++;
                }
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
