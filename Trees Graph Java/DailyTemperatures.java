import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ans=dailyTemperatures(temperatures);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public static  int[] dailyTemperatures(int[] temperatures) {
        int[] nextGreater = new int[temperatures.length];
               Stack<Integer> stack = new Stack<>();
               for (int i = temperatures.length - 1; i >= 0; i--) {
                  while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                       stack.pop();
                   }
                   if (stack.isEmpty()) {
                       nextGreater[i] = 0;
                   } else {
                       
                       nextGreater[i] = stack.peek()-i;
                   }
                   stack.push(i);
               }
       
               return nextGreater;
           }   
}


