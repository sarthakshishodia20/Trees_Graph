class Solution {
    public static void assignParents(Node root,HashMap<Node,Node> map){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node currNode=q.poll();
            if(currNode.left!=null){
                q.add(currNode.left);
                map.put(currNode.left,currNode);
            }
            if(currNode.right!=null){
                q.add(currNode.right);
                map.put(currNode.right,currNode);
            }
        }
        return;
    }
    public static Node findNode(Node root,int val){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node currNode=q.poll();
            if(currNode.data==val){
                return currNode;
            }
            if(currNode.left!=null){
                q.add(currNode.left);
            }
            if(currNode.right!=null){
                q.add(currNode.right);
            }
        }
        return null;
    }
    public ArrayList<Integer> Ancestors(Node root, int target) {
        // add your code here
        HashMap<Node,Node> parentMap=new HashMap<>();
        parentMap.put(root,null);
        assignParents(root,parentMap);
        Node targetNode=findNode(root,target);
        ArrayList<Integer> list=new ArrayList<>();
        if(targetNode==null){
            return list;
        }
        // list.add(targetNode.data);
        while(targetNode!=null && parentMap.get(targetNode)!=null){
            list.add(parentMap.get(targetNode).data);
            targetNode=parentMap.get(targetNode);
        }
        return list;
    }
}
