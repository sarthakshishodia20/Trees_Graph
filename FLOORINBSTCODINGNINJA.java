import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        int ans=-1;
        for(int i=0;i<list.size();i++){
            if(list.get(i)<=X){
                ans=list.get(i);
            }
        }
        return ans;
    }
    public static void inorder(TreeNode<Integer> root,List<Integer> l){
        if(root==null){
            return;
        }
        inorder(root.left,l);
        l.add(root.data);
        inorder(root.right,l);
    }
}
