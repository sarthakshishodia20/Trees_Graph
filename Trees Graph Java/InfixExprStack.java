import java.util.*;

public class InfixExprStack{
    public static void main(String[] args) {
        String str="9-5+3*4/6";
        System.out.println(calculate(str));
    }
        public static int calculate(String s) {
            s = s.replaceAll("\\s+", ""); 
            int num = 0;
            char sign = '+';
            Stack<Integer>stack = new Stack<>();
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                if(Character.isDigit(ch)){
                    num=num*10+(ch-48);
                }
                if(!Character.isDigit(ch) || i==s.length()-1){
                    if(sign=='+') stack.push(num);
                    else if(sign=='-') stack.push(-num);
                    else if(sign=='*') stack.push(stack.pop()*num);
                    else stack.push(stack.pop()/num);
                    sign = ch;
                    num = 0;
                }
            }
            
            int ans = 0;
            for(int x:stack) ans+=x;
            return ans;
        
    }
}
