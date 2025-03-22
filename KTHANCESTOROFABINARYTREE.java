import java.util.*;

// class BinaryTreeNode<T> {
//     T data;
//     BinaryTreeNode<T> left;
//     BinaryTreeNode<T> right;

//     public BinaryTreeNode(T data) {
//         this.data = data;
//     }
// }

public class Solution {
    public static void assignParents(HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> map, BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> currNode = q.poll();
            if (currNode.left != null) {
                q.add(currNode.left);
                map.put(currNode.left, currNode);
            }
            if (currNode.right != null) {
                q.add(currNode.right);
                map.put(currNode.right, currNode);
            }
        }
    }

    static int findKthAncestor(BinaryTreeNode<Integer> root, int targetNodeVal, int kth) {
        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap = new HashMap<>();
        assignParents(parentMap, root);
        BinaryTreeNode<Integer> targetNode = findNode(root, targetNodeVal);
        if (targetNode == null) return -1;
        while (kth > 0 && parentMap.containsKey(targetNode)) {
            targetNode = parentMap.get(targetNode);
            kth--;
        }

        return (kth == 0) ? targetNode.data : -1;
    }

    private static BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> root, int value) {
        if (root == null) return null;
        if (root.data == value) return root;
        
        BinaryTreeNode<Integer> leftSearch = findNode(root.left, value);
        return (leftSearch != null) ? leftSearch : findNode(root.right, value);
    }
}
