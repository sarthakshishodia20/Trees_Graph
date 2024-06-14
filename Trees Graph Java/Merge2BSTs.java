import java.util.ArrayList;

public class Merge2BSTs {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    public static void getInorder(TreeNode root,ArrayList<Integer> array){
        if(root==null){
            return ;
        }
        getInorder(root.left, array);
        array.add(root.data);
        getInorder(root.right, array);
    }
    public static TreeNode mergeBSTs(TreeNode root1, TreeNode root2){
        ArrayList<Integer> array1=new ArrayList<>();
        getInorder(root1,array1);

        ArrayList<Integer> array2= new ArrayList<>();
        getInorder(root2,array2);
        ArrayList<Integer> finalArray=new ArrayList<>();

        int i=0;
        int j=0;
        while(i< array1.size() && j<array2.size()){
            if(array1.get(i)<array2.get(j)){
                finalArray.add(array1.get(i));
                i++;

            }
            else{
                finalArray.add(array2.get(j));
                j++;
            }
        }
        while(i<array1.size())
        {
            finalArray.add(array1.get(i));
            i++;
        }
        while(j<array2.size()){
            finalArray.add(array2.get(j));
            j++;
        }
        return createBST(finalArray,0,finalArray.size()-1);
        
    }
    public static TreeNode createBST(ArrayList<Integer> finalArray,int si,int ei){
       if(si>ei){
        return null;
       }
       int mid=si+(ei-si)/2;
       TreeNode root=new TreeNode(finalArray.get(mid));
       root.left=createBST(finalArray, si, mid-1);
       root.right=createBST(finalArray,mid+1,ei);

       return root;

    }
    public static void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.data+ " -> ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
     TreeNode root1=new TreeNode(2);
     root1.left=new TreeNode(1);
     root1.right=new TreeNode(4);

     TreeNode root2=new TreeNode(9);
     root2.left=new TreeNode(3);
     root2.right= new TreeNode(12);
     TreeNode root=mergeBSTs(root1, root2);
     preOrder(root);


    }
    
}
