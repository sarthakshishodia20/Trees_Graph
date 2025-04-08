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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int ele:to_delete){
            set.add(ele);
        }
        if(root==null){
            return  ans;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode currNode=q.poll();
            if(currNode.left!=null){
                q.add(currNode.left);
                if(set.contains(currNode.left.val)){
                    currNode.left=null;
                }
            }
            if(currNode.right!=null){
                q.add(currNode.right);
                if(set.contains(currNode.right.val)){
                    currNode.right=null;
                }
            }
            if(set.contains(currNode.val)){
                if(currNode.left!=null){
                    ans.add(currNode.left);
                }
                if(currNode.right!=null){
                    ans.add(currNode.right);
                }
            }
        }
        if(!set.contains(root.val)){
           ans.add(root) ;
        }
        return ans;
    }
}
