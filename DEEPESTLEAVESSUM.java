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
    static class Pair implements Comparable<Pair>{
        TreeNode node;
        int depth;
        public Pair(TreeNode node,int depth){
            this.node=node;
            this.depth=depth;
        }
        @Override
        public int compareTo(Pair other){
            return other.depth-this.depth;
        }
    }
    public int deepestLeavesSum(TreeNode root) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int D=0;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                TreeNode currNode=q.poll();
                pq.add(new Pair(currNode,D));
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
            D++;
        }
        int sum=0;
        int prev=-1;
        while(!pq.isEmpty()){
            Pair p1=pq.poll();
            int currentDepth=p1.depth;
            if(prev==-1 || currentDepth==prev){
                sum+=p1.node.val;
                prev=currentDepth;
            }
        }
        return sum;
    }
}
