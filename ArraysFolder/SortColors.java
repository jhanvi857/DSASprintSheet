package ArraysFolder;
//  Here, 0 to low-1 =  0
//        low to high-1 = 1
//        high to n-1 = 2.
public class SortColors {
    public void SortArr(int nums[]) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(mid<=high) {
            if(nums[mid]==0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            } else if(nums[mid]==1) {
                mid++;
            } else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}
