class Solution {
    /*class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }*/
    public static void assignParents(Node root,HashMap<Node,Node> map){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
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
    public static Node findtarget(Node root,int target){
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
    public static int minTime(Node root, int target) {
        // code here
        HashMap<Node,Node> map=new HashMap<>();
        assignParents(root,map);
        Node targetNode=findtarget(root,target);
        return bfs(map,targetNode);
        
    }
    public static int bfs(HashMap<Node,Node> map,Node targetNode)
    {
        Queue<Node> q=new LinkedList<>();
        HashSet<Node> visited=new HashSet<>();
        q.add(targetNode);
        int time=0;
        visited.add(targetNode);
        // boolean burned=false;
        while(!q.isEmpty()){
            int n=q.size();
            boolean burned=false;
            for(int i=0;i<n;i++){
                Node currNode=q.poll();
                if(currNode.left!=null && !visited.contains(currNode.left)){
                    q.add(currNode.left);
                    visited.add(currNode.left);
                    burned=true;
                }
                if(currNode.right!=null && !visited.contains(currNode.right)){
                    q.add(currNode.right);
                    visited.add(currNode.right);
                    burned=true;
                }
                if(map.get(currNode)!=null && !visited.contains(map.get(currNode))){
                    q.add(map.get(currNode));
                    visited.add(map.get(currNode));
                    burned=true;
                }
            }
            if(burned==true){
                time++;
            }
        }
        return time;
    }
}
