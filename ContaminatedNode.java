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
class FindElements {
    static HashSet<Integer> set;
    public FindElements(TreeNode root) {
        set=new HashSet<>();
        bfs(root);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
    public static void bfs(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> q=new LinkedList<>();
        root.val=0;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode currNode=q.poll();
            set.add(currNode.val);
            if(currNode.left!=null){
                int x=currNode.val;
                currNode.left.val=2*x+1;
                q.add(currNode.left);
            }
            if(currNode.right!=null){
                int x=currNode.val;
                currNode.right.val=2*x+2;
                q.add(currNode.right);
            }
        }
        return;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
