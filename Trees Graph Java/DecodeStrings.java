import java.util.Stack;

public class DecodeStrings {
    public static void main(String[] args) {
        String str="3[a]2[bc]";
        String answer=decodeString(str);
        System.out.println(answer);
    }
    public static String decodeString(String s) {
        Stack<Integer> numStack=new Stack<>();
        Stack<StringBuilder> strStack=new Stack<>();
        StringBuilder str=new StringBuilder();
        int num=0;
        for(char c:s.toCharArray()){
            if(c>='0' && c<='9'){
                num=num*10+(c-'0');

            }
            else if(c=='['){
                strStack.push(str);
                str=new StringBuilder();

                numStack.push(num);
                num=0;
            }
            else if(c==']'){
                StringBuilder temp=str;
                str=strStack.pop();
                int count=numStack.pop();
                while(count-->0){
                    str.append(temp);
                }
            }
            else{
                str.append(c);
            }
            
        }
        return str.toString();
    }
    
}
