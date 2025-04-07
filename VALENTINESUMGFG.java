class Solution{
    public static void assignparents(Node root,HashMap<Node,Node> map){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        map.put(root,null);
        while(!q.isEmpty()){
            Node currNode=q.poll();
            if(currNode.left!=null){
                map.put(currNode.left,currNode);
                q.add(currNode.left);
            }
            if(currNode.right!=null){
                map.put(currNode.right,currNode);
                q.add(currNode.right);
            }
        }
        return;
    }
    public static Node getNode(Node root,int target){
        Node ans=null;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Node currNode=q.poll();
                if(currNode.data==target){
                    ans=currNode;
                    break;
                }
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
        return ans;
    }
    static int sum_at_distK(Node root, int target, int k){
        // Your code goes here
        HashMap<Node,Node> map=new HashMap<>();
        assignparents(root,map);
        Node targetNode=getNode(root,target);
        int ans=Sum(targetNode,map,k);
        return ans;
    }
    public static int Sum(Node root,HashMap<Node,Node> map,int k){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int sum=0;
        HashSet<Node> visited=new HashSet<>();
        visited.add(root);
        while(!q.isEmpty()){
            Pair current=q.poll();
            if(current.distance<=k){
                sum+=current.node.data;
            }
            if(current.node.left!=null && !visited.contains(current.node.left)){;
                q.add(new Pair(current.node.left,current.distance+1));
                visited.add(current.node.left);
            }
            if(current.node.right!=null && !visited.contains(current.node.right)){
                q.add(new Pair(current.node.right,current.distance+1));
                visited.add(current.node.right);
            }
            if(map.get(current.node)!=null && !visited.contains(map.get(current.node)))
            {
                q.add(new Pair(map.get(current.node),current.distance+1));
                visited.add(map.get(current.node));
            }
        }
        return sum;
    }
    static class Pair{
        Node node;
        int distance;
        public Pair(Node node,int d){
            this.node=node;
            this.distance=d;
        }
    }
}
