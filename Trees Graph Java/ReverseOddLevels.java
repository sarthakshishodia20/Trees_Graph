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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null){
            return root;
        }
        Queue<TreeNode> q=new LinkedList<>();
        int level=0;
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<TreeNode> currentList=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode currNode=q.poll();
                currentList.add(currNode);
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }

            if(level%2==1){
                int left=0;
                int right=currentList.size()-1;
                while(left<right){
                    int temp=currentList.get(left).val;
                    currentList.get(left).val=currentList.get(right).val;
                    currentList.get(right).val=temp;
                    left++;
                    right--;
                }
            }
            level++;
        }
        return root;
    }
}
