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
    public String smallestFromLeaf(TreeNode root) {
        List<List<Character>> result=new ArrayList<>();
        List<Character> path=new ArrayList<>();
        findAllPaths(result,path,root);
        List<String> ans=new ArrayList<>();
        for(List<Character> lst:result){
            StringBuilder sb=new StringBuilder();
            for(char c:lst){
                sb.append(c);
            }
            ans.add(sb.reverse().toString());
        }
        Collections.sort(ans);
        return ans.get(0);
    }
    public static void findAllPaths(List<List<Character>> result,List<Character> path,TreeNode root){
        if(root==null){
            return;
        }
        path.add((char)('a'+root.val));
        if(root.left==null && root.right==null){
            result.add(new ArrayList<>(path));
        }
        else{
            findAllPaths(result,path,root.left);
            findAllPaths(result,path,root.right);
        }
        path.remove(path.size()-1);
    }
}
