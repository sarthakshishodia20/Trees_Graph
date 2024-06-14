import java.util.*;
public class SimplifyPath {
    public static void main(String[] args) {
        String str="/home/user/../sarthak/.";
        System.out.println(simplifyPath(str));
    }
    public static String simplifyPath(String path) {
        String[] arr=path.split("/");
        Stack<String> s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }
            else if(arr[i].equals(".")|| arr[i].equals("")){
                continue;
            }
            else{
                s.push(arr[i]);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String dir:s){
            sb.append("/");
            sb.append(dir);
        }
        if(sb.length()==0){
            sb.append("/");
        }
        return sb.toString();
    }
    
}
