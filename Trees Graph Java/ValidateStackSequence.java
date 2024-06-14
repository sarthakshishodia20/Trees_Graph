import java.util.Stack;

public class ValidateStackSequence {
    public static void main(String[] args) {
        int[] pushed={1,2,3,4,5};
        int[] popped={4,5,3,2,1};
        System.out.println(validate(pushed, popped));
    }
    public static boolean validate(int[] pushed,int popped[]){
        int j=0;
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<pushed.length;i++){
            while(!s.isEmpty() && s.peek()==popped[j]){
                s.pop();
                j++;
            }
        }
        return s.isEmpty();
    }
    
}
