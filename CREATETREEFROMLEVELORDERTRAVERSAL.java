// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int[] level={1,2,3,4,5,6,7,8,9,10};
        Node root=getRoot(level);
        printTree(root);
    }
    public static Node getRoot(int[] level){
        int index=0;
        Node root=new Node(level[index]);
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Node currNode=q.poll();
                if(currNode.left==null && index<level.length){
                    Node newNode=new Node(level[index]);
                    currNode.left=newNode;
                    q.add(newNode);
                }
                index++;
                if(currNode.right==null && index<level.length){
                    Node newNode=new Node(level[index]);
                    currNode.right=newNode;
                    q.add(newNode);
                }
                index++;
            }
        }
        return root;
    }
    public static void printTree(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int n=q.size();
            for(int i=0;i<n;i++){
                Node currNode=q.poll();
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
            System.out.println();
        }
        return;
    }
}
