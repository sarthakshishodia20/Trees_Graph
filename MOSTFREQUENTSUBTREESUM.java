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
    private HashMap<Integer,Integer> map=new HashMap<>();
    private int maxFrequency;
    private void preordertraversal(TreeNode root){
        if(root==null){
            return;
        }
        int currSum=calculateSubtreeSum(root);
        map.put(currSum,map.getOrDefault(currSum,0)+1);
        maxFrequency=Math.max(maxFrequency,map.get(currSum));
        preordertraversal(root.left);
        preordertraversal(root.right);
    }
    private int calculateSubtreeSum(TreeNode root){
        if(root==null){
            return 0;
        }
        return root.val+calculateSubtreeSum(root.left)+calculateSubtreeSum(root.right);
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        preordertraversal(root);
        List<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==maxFrequency){
                list.add(entry.getKey());
            }
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}
