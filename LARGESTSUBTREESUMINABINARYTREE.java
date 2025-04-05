class Solution {
    public static int findLargestSubtreeSum(Node root) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        helper(root,pq);
        return pq.poll();
    }
    public static void helper(Node root,PriorityQueue<Integer> pq){
        if(root==null){
            return;
        }
        int subtreeSum=getSum(root);
        pq.add(subtreeSum);
        helper(root.left,pq);
        helper(root.right,pq);
        
    }
    public static int getSum(Node root){
        if(root==null){
            return 0;
        }
        return root.data+getSum(root.left)+getSum(root.right);
    }
}
