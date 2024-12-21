/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        if(root==null){
            return result;
        }
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                Node currNode=q.poll();
                list.add(currNode.val);
                int childrens=currNode.children.size();
                for(int k=0;k<childrens;k++){
                    if(currNode.children.get(k)!=null){
                    q.add(currNode.children.get(k));
                    }
                }
            }
            result.add(list);
        }
        return result;
    }
}
