import java.util.Stack;

public class ScoreParenthesis {
    public static void main(String[] args) {
        String str="()()";
        System.out.println(scopa(str));
    }
    public static int scopa(String s){
        Stack<Integer>st=new Stack<>();
        int score=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
            {
                st.push(score);
                score=0;
            }
            else{
                score=st.pop()+Math.max(2*score,1);
            }
        }
        return score;
        
        
    }
    
}
