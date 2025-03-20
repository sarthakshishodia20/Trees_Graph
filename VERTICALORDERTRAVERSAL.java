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
    static class Tuple{
        TreeNode node;
        int col;
        int row;
        public Tuple(TreeNode node,int c,int r){
            this.node=node;
            this.col=c;
            this.row=r;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple t=q.poll();
            TreeNode node=t.node;
            int col=t.col;
            int row=t.row;
            map.putIfAbsent(col,new TreeMap<>());
            map.get(col).putIfAbsent(row,new PriorityQueue<>());
            map.get(col).get(row).add(node.val);

            if(node.left!=null){
                q.add(new Tuple(node.left,col-1,row+1));
            }
            if(node.right!=null){
                q.add(new Tuple(node.right,col+1,row+1));
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> entry:map.values()){
            List<Integer> colMap=new ArrayList<>();
            for(PriorityQueue<Integer> pq:entry.values()){
                while(!pq.isEmpty()){
                    colMap.add(pq.poll());
                }
            }
            result.add(colMap);
        }
        return result;
    }
}
