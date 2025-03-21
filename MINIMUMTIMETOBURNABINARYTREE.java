/**********************************************************	
	
	Following is the representation of Binary Tree Node:
 	
 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

*********************************************************/
import java.util.*;
public class Solution
{
public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        // Write your code here.
		HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> parentMap=new HashMap<>();
		HashSet<BinaryTreeNode<Integer>> visited=new HashSet<>();
		Queue<BinaryTreeNode<Integer>> q =new LinkedList<>();
		BinaryTreeNode<Integer> starting=assignParents(parentMap,root,start);
		q.add(starting);
		visited.add(starting);
		int time=0;
		while(!q.isEmpty())
		{
			int n=q.size();
			boolean burned=false;
			for(int i=0;i<n;i++){
				BinaryTreeNode<Integer> currNode=q.poll();
				if(currNode.left!=null && !visited.contains(currNode.left)){
					q.add(currNode.left);
					burned=true;
					visited.add(currNode.left);
				}
				if(currNode.right!=null && !visited.contains(currNode.right)){
					q.add(currNode.right);
					burned=true;
					visited.add(currNode.right);
				}
				if(parentMap.containsKey(currNode) && !visited.contains(parentMap.get(currNode))){
					q.add(parentMap.get(currNode));
					visited.add(parentMap.get(currNode));
					burned=true;
				}
			}
			if(burned){
				time++;
			}
		}
		return time;

    }
	public static BinaryTreeNode<Integer> assignParents(HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> map,BinaryTreeNode<Integer> root,int target){
		BinaryTreeNode<Integer> ans=null;
		Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			BinaryTreeNode<Integer> currNode=q.poll();
			if(currNode.data==target){
				ans=currNode;
			}
			if(currNode.left!=null){
				q.add(currNode.left);
				map.put(currNode.left,currNode);
			}
			if(currNode.right!=null){
				q.add(currNode.right);
				map.put(currNode.right,currNode);
			}
		}
		return ans;
	}
}
