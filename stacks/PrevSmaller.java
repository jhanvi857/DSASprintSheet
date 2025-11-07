package stacks;

import java.util.HashMap;
import java.util.Stack;

public class PrevSmaller {
    public int[] previousSmaller(int nums1[],int nums2[]) {
        int n = nums1.length;
        HashMap<Integer,Integer> m = new HashMap<>();
        Stack<Integer>s = new Stack<>();
        int arr[] = new int[n];
        for(int i=nums2.length-1;i>=0;i--){
            while(s.size()>0 && s.peek()>=nums2[i]){
                s.pop();
            }
            if(s.isEmpty()){
                m.put(nums2[i], -1); 
            } else {
                m.put(nums2[i],s.peek());
            }
            s.push(nums2[i]);
        }
        for(int i=0;i<n;i++){
            arr[i] = m.get(nums1[i]);
        }
        return arr;
    }
}
