class Tree {
    public static ArrayList <Integer> diagonalSum(Node root) 
    {
        // code here.
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int sum=0;
            int n=q.size();
            for(int i=0;i<n;i++){
                Node currNode=q.poll();
                while(currNode!=null){
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    sum+=currNode.data;
                    currNode=currNode.right;
                }
            }
            ans.add(sum);
        }
        return ans;
    }
}
