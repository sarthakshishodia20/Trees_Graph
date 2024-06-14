import java.util.*;
public class BSTtoBalancedBST {
    public static void getInorder(TreeNode root,ArrayList<Integer> inorder){
        if(root==null){
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);

    }
    public static TreeNode createBST(ArrayList<Integer> inorder,int si,int ei){
        if(si>ei){
            return null;
        }
        int mid=si+(ei-si)/2;
        TreeNode root=new TreeNode(inorder.get(mid));
        root.left=createBST(inorder, si, mid-1);
        root.right=createBST(inorder, mid+1, ei);
        return root;

    }
    public static TreeNode balanceBST(TreeNode root){
        ArrayList<Integer> inorder=new ArrayList<>();
        getInorder(root, inorder);
        root=createBST(inorder, 0, inorder.size()-1);
        return root;
    }
    public static void main(String[] args) {
        // Create a sample Binary Search Tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        
        // Print original BST inorder traversal
        System.out.println("Original BST inorder traversal:");
        printInorder(root);
        
        // Balance the BST
        root = balanceBST(root);
        
        // Print balanced BST inorder traversal
        System.out.println("\nBalanced BST inorder traversal:");
        printInorder(root);
    }
    
    public static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    
    
}
