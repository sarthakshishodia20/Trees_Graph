import java.util.Arrays;

public class LargestPositiveIntegerWithNegative {
    public static void main(String[] args) {
        int[] arr={-1,2,-3,3};
        System.out.println(largest(arr));
    }
    public static int largest(int [] nums){
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        while(left<right && nums[left]<0 && nums[right]>0){
            if(Math.abs(nums[left])==nums[right]){
                return nums[right];
            }
            else if (Math.abs(nums[left])>nums[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return -1;
    }
    
}
