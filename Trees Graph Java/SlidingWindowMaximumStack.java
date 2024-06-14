import java.util.*;
public class SlidingWindowMaximumStack {
    public static int[]  maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int z=0;
        Stack<Integer> s=new Stack<>();
        int[] nge=new int[n];
        s.push(n-1);
        nge[n-1]=n;
        for(int i=n-2;i>=0;i--){
            while(!s.isEmpty() && nums[i]>nums[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nge[i]=n;
            }
            else{
                nge[i]=s.peek();
            }
            s.push(i);
        }
        int j=0;
        for(int i=0;i<n-k+1;i++){
            if(j>=i+k) j=i;
            int max=nums[j];
            while(j<i+k){
                max=nums[j];
                j=nge[j];
            }
            ans[z++]=max;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,3,-1,-3,5,3,6,7};
        int k=3;
        int[] res=maxSlidingWindow(arr,k);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
    
}
