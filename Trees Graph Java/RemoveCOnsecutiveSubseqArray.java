import java.util.Stack;

public class RemoveCOnsecutiveSubseqArray {
    public static int[] remove(int array[])
    {
        Stack<Integer> s=new Stack<>();
        int n=array.length;
        for(int i=0;i<n;i++){
            if(s.size()==0 || s.peek()!=array[i]){
                s.push(array[i]);
            
            }else if(array[i]==s.peek()){
                if(i==n-1 || array[i]!=array[i+1]){
                    s.pop();
                }
            }
        }
        int res[]=new int[s.size()];
        for(int i=res.length-1;i>=0;i--){
            res[i]=s.pop();
        }
        return res;

    }
    public static void main(String[] args) {
        int arr[]={1,2,2,3,4,5,5,6,6,6,7,8,9,10,10,10};
        int[] res=remove(arr);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        // System.out.println(res.toString());
        
    }
    
}
