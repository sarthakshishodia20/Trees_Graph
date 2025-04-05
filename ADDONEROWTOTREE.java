/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newNode=new TreeNode(val);
            newNode.left=root;
            return newNode;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int currentDepth=1;
        while(!q.isEmpty()){
            int n=q.size();
            if(currentDepth==depth-1){
                for(int i=0;i<n;i++){
                    TreeNode currNode=q.poll();
                    TreeNode tempLeft=currNode.left;
                    TreeNode tempRight=currNode.right;
                    currNode.left=new TreeNode(val);
                    currNode.right=new TreeNode(val);
                    currNode.left.left=tempLeft;
                    currNode.right.right=tempRight;
                }
                break;
            }
            else{
                for(int i=0;i<n;i++){
                    TreeNode currNode=q.poll();
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
            currentDepth++;
        }
        return root;
    }
}
